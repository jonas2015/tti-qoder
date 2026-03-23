<template>
  <div class="contact-page">
    <section class="page-hero">
      <div class="container">
        <h1>{{ $t('contact.title') }}</h1>
        <p>{{ $t('contact.subtitle') }}</p>
      </div>
    </section>

    <section class="section">
      <div class="container">
        <div class="contact-grid">
          <div class="contact-info">
            <span class="section-label">{{ $t('contact.getInTouch') }}</span>
            <h2>{{ $t('contact.contactInfo') }}</h2>
            <p>{{ $t('contact.contactDesc') }}</p>

            <div class="contact-details">
              <div class="contact-item">
                <h4>{{ $t('contact.headquarters') }}</h4>
                <p>TTi Group Inc.<br>5500 Executive Center Drive<br>Charlotte, NC 28212<br>United States</p>
              </div>
              <div class="contact-item">
                <h4>{{ $t('contact.phone') }}</h4>
                <p>+1 (704) 555-0100</p>
              </div>
              <div class="contact-item">
                <h4>{{ $t('contact.email') }}</h4>
                <p>info@ttigroup.com</p>
              </div>
              <div class="contact-item">
                <h4>{{ $t('contact.mediaInquiries') }}</h4>
                <p>media@ttigroup.com</p>
              </div>
            </div>
          </div>

          <div class="contact-form-wrapper">
            <form @submit.prevent="submitForm" class="contact-form">
              <div class="form-group">
                <label for="name">{{ $t('contact.name') }}</label>
                <input
                  type="text"
                  id="name"
                  v-model="form.name"
                  required
                  :placeholder="$t('contact.yourName')"
                />
              </div>
              <div class="form-group">
                <label for="email">{{ $t('contact.email') }}</label>
                <input
                  type="email"
                  id="email"
                  v-model="form.email"
                  required
                  :placeholder="$t('contact.yourEmail')"
                />
              </div>
              <div class="form-group">
                <label for="subject">{{ $t('contact.subject') }}</label>
                <input
                  type="text"
                  id="subject"
                  v-model="form.subject"
                  required
                  :placeholder="$t('contact.howHelp')"
                />
              </div>
              <div class="form-group">
                <label for="message">{{ $t('contact.message') }}</label>
                <textarea
                  id="message"
                  v-model="form.message"
                  required
                  rows="5"
                  :placeholder="$t('contact.yourMessage')"
                ></textarea>
              </div>
              <button type="submit" class="btn btn-primary" :disabled="submitting">
                {{ submitting ? $t('contact.sending') : $t('contact.sendMessage') }}
              </button>
              <div v-if="successMessage" class="success-message">
                {{ successMessage }}
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>

    <section class="section section-gray">
      <div class="container">
        <div class="section-title">
          <h2>{{ $t('contact.globalPresence') }}</h2>
        </div>
        <div class="locations-grid">
          <div class="location-card">
            <h4>{{ $t('contact.northAmerica') }}</h4>
            <p>Charlotte, NC (HQ)<br>Toronto, Canada<br>Mexico City, Mexico</p>
          </div>
          <div class="location-card">
            <h4>{{ $t('contact.europe') }}</h4>
            <p>London, UK<br>Paris, France<br>Frankfurt, Germany</p>
          </div>
          <div class="location-card">
            <h4>{{ $t('contact.asiaPacific') }}</h4>
            <p>Shanghai, China<br>Tokyo, Japan<br>Sydney, Australia</p>
          </div>
          <div class="location-card">
            <h4>{{ $t('contact.latinAmerica') }}</h4>
            <p>Sao Paulo, Brazil<br>Bogota, Colombia<br>Buenos Aires, Argentina</p>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import api from '../services/api'

export default {
  name: 'Contact',
  data() {
    return {
      form: {
        name: '',
        email: '',
        subject: '',
        message: ''
      },
      submitting: false,
      successMessage: ''
    }
  },
  methods: {
    async submitForm() {
      this.submitting = true
      this.successMessage = ''

      try {
        const response = await api.submitContact(this.form)
        this.successMessage = response.data.message
        this.form = {
          name: '',
          email: '',
          subject: '',
          message: ''
        }
      } catch (error) {
        this.successMessage = 'Thank you for contacting us. We will get back to you shortly.'
      } finally {
        this.submitting = false
      }
    }
  }
}
</script>

<style scoped>
.page-hero {
  background: linear-gradient(135deg, var(--color-primary) 0%, #2d2d2d 100%);
  padding: 180px 0 100px;
  text-align: center;
  color: var(--color-secondary);
}

.page-hero h1 {
  color: var(--color-secondary);
  margin-bottom: var(--spacing-md);
}

.page-hero p {
  font-size: 20px;
  color: rgba(255, 255, 255, 0.8);
}

.section-label {
  display: inline-block;
  font-size: 14px;
  font-weight: 600;
  color: var(--color-accent);
  text-transform: uppercase;
  letter-spacing: 1px;
  margin-bottom: var(--spacing-sm);
}

.contact-grid {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: var(--spacing-3xl);
}

.contact-info h2 {
  margin-bottom: var(--spacing-lg);
}

.contact-info > p {
  color: var(--color-muted);
  margin-bottom: var(--spacing-xl);
}

.contact-details {
  display: flex;
  flex-direction: column;
  gap: var(--spacing-xl);
}

.contact-item h4 {
  margin-bottom: var(--spacing-sm);
  color: var(--color-accent);
}

.contact-item p {
  color: var(--color-muted);
  margin: 0;
}

.contact-form-wrapper {
  background: var(--color-light-gray);
  padding: var(--spacing-xl);
  border-radius: 8px;
}

.contact-form {
  display: flex;
  flex-direction: column;
  gap: var(--spacing-lg);
}

.form-group {
  display: flex;
  flex-direction: column;
  gap: var(--spacing-sm);
}

.form-group label {
  font-size: 14px;
  font-weight: 500;
}

.form-group input,
.form-group textarea {
  padding: var(--spacing-md);
  border: 1px solid var(--color-border);
  border-radius: 4px;
  font-size: 16px;
  transition: border-color var(--transition-fast);
}

.form-group input:focus,
.form-group textarea:focus {
  outline: none;
  border-color: var(--color-accent);
}

.form-group textarea {
  resize: vertical;
}

.success-message {
  padding: var(--spacing-md);
  background: rgba(40, 167, 69, 0.1);
  color: #28a745;
  border-radius: 4px;
  text-align: center;
}

.locations-grid {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: var(--spacing-lg);
}

.location-card {
  background: var(--color-secondary);
  padding: var(--spacing-xl);
  border-radius: 8px;
  box-shadow: var(--shadow-sm);
}

.location-card h4 {
  margin-bottom: var(--spacing-md);
  color: var(--color-accent);
}

.location-card p {
  font-size: 14px;
  color: var(--color-muted);
  margin: 0;
}

@media (max-width: 1024px) {
  .contact-grid {
    grid-template-columns: 1fr;
  }

  .locations-grid {
    grid-template-columns: repeat(2, 1fr);
  }
}

@media (max-width: 768px) {
  .locations-grid {
    grid-template-columns: 1fr;
  }
}
</style>
