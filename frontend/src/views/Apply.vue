<template>
  <div class="apply-page">
    <section class="page-hero">
      <div class="container">
        <h1>{{ $t('apply.title') }}</h1>
        <p>{{ job ? job.title : '' }}</p>
      </div>
    </section>

    <section class="section">
      <div class="container">
        <div class="apply-container">
          <div class="job-summary" v-if="job">
            <h3>{{ job.title }}</h3>
            <p>{{ job.department }} | {{ job.location }}</p>
          </div>

          <form @submit.prevent="submitApplication" class="apply-form">
            <div class="form-row">
              <div class="form-group">
                <label>{{ $t('apply.firstName') }} *</label>
                <input type="text" v-model="form.firstName" required />
              </div>
              <div class="form-group">
                <label>{{ $t('apply.lastName') }} *</label>
                <input type="text" v-model="form.lastName" required />
              </div>
            </div>

            <div class="form-row">
              <div class="form-group">
                <label>{{ $t('apply.email') }} *</label>
                <input type="email" v-model="form.email" required />
              </div>
              <div class="form-group">
                <label>{{ $t('apply.phone') }}</label>
                <input type="tel" v-model="form.phone" />
              </div>
            </div>

            <div class="form-group">
              <label>{{ $t('apply.address') }}</label>
              <input type="text" v-model="form.address" />
            </div>

            <div class="form-row">
              <div class="form-group">
                <label>{{ $t('apply.city') }}</label>
                <input type="text" v-model="form.city" />
              </div>
              <div class="form-group">
                <label>{{ $t('apply.country') }}</label>
                <input type="text" v-model="form.country" />
              </div>
            </div>

            <div class="form-group">
              <label>{{ $t('apply.linkedin') }}</label>
              <input type="url" v-model="form.linkedin" placeholder="https://linkedin.com/in/..." />
            </div>

            <div class="form-group">
              <label>{{ $t('apply.resume') }} *</label>
              <div class="file-upload">
                <input type="file" id="resume" @change="handleResumeUpload" accept=".pdf,.doc,.docx" />
                <label for="resume" class="file-label">
                  <span v-if="form.resumeName">{{ form.resumeName }}</span>
                  <span v-else>{{ $t('apply.chooseFile') }}</span>
                </label>
              </div>
            </div>

            <div class="form-group">
              <label>{{ $t('apply.coverLetter') }}</label>
              <textarea v-model="form.coverLetter" rows="4" :placeholder="$t('apply.coverLetterPlaceholder')"></textarea>
            </div>

            <div class="form-group">
              <label class="checkbox-label">
                <input type="checkbox" v-model="form.consent" required />
                <span>{{ $t('apply.consent') }}</span>
              </label>
            </div>

            <button type="submit" class="btn btn-primary" :disabled="submitting">
              {{ submitting ? $t('apply.submitting') : $t('apply.submit') }}
            </button>

            <div v-if="successMessage" class="success-message">
              {{ successMessage }}
            </div>
          </form>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import api from '../services/api'

export default {
  name: 'Apply',
  data() {
    return {
      job: null,
      form: {
        firstName: '',
        lastName: '',
        email: '',
        phone: '',
        address: '',
        city: '',
        country: '',
        linkedin: '',
        resume: null,
        resumeName: '',
        coverLetter: '',
        consent: false
      },
      submitting: false,
      successMessage: ''
    }
  },
  async mounted() {
    const jobId = this.$route.query.jobId
    if (jobId) {
      try {
        const response = await api.getCareers()
        this.job = response.data.find(j => j.id === parseInt(jobId))
      } catch (error) {
        console.error('Error loading job:', error)
      }
    }
  },
  methods: {
    handleResumeUpload(event) {
      const file = event.target.files[0]
      if (file) {
        this.form.resume = file
        this.form.resumeName = file.name
      }
    },
    async submitApplication() {
      this.submitting = true
      this.successMessage = ''

      try {
        // Simulate API call
        await new Promise(resolve => setTimeout(resolve, 1000))
        this.successMessage = this.$t('apply.success')
        this.form = {
          firstName: '',
          lastName: '',
          email: '',
          phone: '',
          address: '',
          city: '',
          country: '',
          linkedin: '',
          resume: null,
          resumeName: '',
          coverLetter: '',
          consent: false
        }
      } catch (error) {
        console.error('Error submitting application:', error)
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

.apply-container {
  max-width: 700px;
  margin: 0 auto;
}

.job-summary {
  background: var(--color-light-gray);
  padding: var(--spacing-xl);
  border-radius: 8px;
  margin-bottom: var(--spacing-xl);
  border-left: 4px solid var(--color-accent);
}

.job-summary h3 {
  margin-bottom: var(--spacing-xs);
}

.job-summary p {
  color: var(--color-muted);
  margin: 0;
}

.apply-form {
  display: flex;
  flex-direction: column;
  gap: var(--spacing-lg);
}

.form-row {
  display: grid;
  grid-template-columns: 1fr 1fr;
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

.file-upload input[type="file"] {
  display: none;
}

.file-label {
  display: block;
  padding: var(--spacing-lg);
  border: 2px dashed var(--color-border);
  border-radius: 4px;
  text-align: center;
  cursor: pointer;
  transition: all var(--transition-fast);
}

.file-label:hover {
  border-color: var(--color-accent);
  background: var(--color-light-gray);
}

.checkbox-label {
  display: flex;
  align-items: center;
  gap: var(--spacing-sm);
  cursor: pointer;
}

.checkbox-label input {
  width: 18px;
  height: 18px;
}

.success-message {
  padding: var(--spacing-md);
  background: rgba(40, 167, 69, 0.1);
  color: #28a745;
  border-radius: 4px;
  text-align: center;
}

@media (max-width: 768px) {
  .form-row {
    grid-template-columns: 1fr;
  }
}
</style>
