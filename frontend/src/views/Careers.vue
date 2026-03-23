<template>
  <div class="careers-page">
    <section class="page-hero">
      <div class="container">
        <h1>{{ $t('careers.title') }}</h1>
        <p>{{ $t('careers.subtitle') }}</p>
      </div>
    </section>

    <section class="section">
      <div class="container">
        <div class="content-block">
          <div class="content-text">
            <span class="section-label">{{ $t('careers.joinTeam') }}</span>
            <h2>{{ $t('careers.whyWork') }}</h2>
            <p>{{ $t('careers.whyDesc') }}</p>
            <ul class="benefits-list">
              <li>{{ $t('careers.benefits.compensation') }}</li>
              <li>{{ $t('careers.benefits.development') }}</li>
              <li>{{ $t('careers.benefits.wellness') }}</li>
              <li>{{ $t('careers.benefits.balance') }}</li>
              <li>{{ $t('careers.benefits.global') }}</li>
            </ul>
          </div>
          <div class="content-image">
            <img src="https://images.unsplash.com/photo-1521737711867-e3b97375f902?w=600" alt="Team" />
          </div>
        </div>
      </div>
    </section>

    <section class="section section-gray">
      <div class="container">
        <div class="section-title">
          <span class="section-label">{{ $t('careers.openPositions') }}</span>
          <h2>{{ $t('careers.currentOpportunities') }}</h2>
        </div>
        <div class="jobs-list">
          <div v-for="job in jobs" :key="job.id" class="job-card">
            <div class="job-info">
              <h3>{{ job.title }}</h3>
              <div class="job-meta">
                <span>{{ job.department }}</span>
                <span>{{ job.location }}</span>
                <span>{{ job.type }}</span>
              </div>
            </div>
            <router-link :to="'/apply?jobId=' + job.id" class="btn btn-outline">{{ $t('careers.applyNow') }}</router-link>
          </div>
        </div>
      </div>
    </section>

    <section class="section">
      <div class="container">
        <div class="section-title">
          <h2>{{ $t('careers.culture') }}</h2>
        </div>
        <div class="culture-grid">
          <div class="culture-card">
            <h4>{{ $t('careers.innovation') }}</h4>
            <p>{{ $t('careers.innovationDesc') }}</p>
          </div>
          <div class="culture-card">
            <h4>{{ $t('careers.collaboration') }}</h4>
            <p>{{ $t('careers.collaborationDesc') }}</p>
          </div>
          <div class="culture-card">
            <h4>{{ $t('careers.integrity') }}</h4>
            <p>{{ $t('careers.integrityDesc') }}</p>
          </div>
          <div class="culture-card">
            <h4>{{ $t('careers.excellence') }}</h4>
            <p>{{ $t('careers.excellenceDesc') }}</p>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import api from '../services/api'

export default {
  name: 'Careers',
  data() {
    return {
      jobs: []
    }
  },
  async mounted() {
    try {
      const response = await api.getCareers()
      this.jobs = response.data
    } catch (error) {
      console.error('Error loading jobs:', error)
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

.content-block {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: var(--spacing-3xl);
  align-items: center;
}

.content-text h2 {
  margin-bottom: var(--spacing-lg);
}

.benefits-list {
  margin-top: var(--spacing-lg);
}

.benefits-list li {
  position: relative;
  padding-left: var(--spacing-lg);
  margin-bottom: var(--spacing-sm);
  color: var(--color-muted);
}

.benefits-list li::before {
  content: '✓';
  position: absolute;
  left: 0;
  color: var(--color-accent);
  font-weight: 700;
}

.content-image {
  border-radius: 8px;
  overflow: hidden;
}

.content-image img {
  width: 100%;
  height: 400px;
  object-fit: cover;
}

.jobs-list {
  display: flex;
  flex-direction: column;
  gap: var(--spacing-md);
}

.job-card {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background: var(--color-secondary);
  border: 1px solid var(--color-border);
  border-radius: 8px;
  padding: var(--spacing-xl);
  transition: all var(--transition-base);
}

.job-card:hover {
  box-shadow: var(--shadow-md);
}

.job-info h3 {
  margin-bottom: var(--spacing-sm);
}

.job-meta {
  display: flex;
  gap: var(--spacing-lg);
  color: var(--color-muted);
  font-size: 14px;
}

.job-meta span {
  position: relative;
}

.job-meta span:not(:last-child)::after {
  content: '•';
  position: absolute;
  right: -10px;
  color: var(--color-border);
}

.culture-grid {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: var(--spacing-lg);
}

.culture-card {
  padding: var(--spacing-xl);
  background: var(--color-light-gray);
  border-radius: 8px;
  text-align: center;
}

.culture-card h4 {
  margin-bottom: var(--spacing-md);
  color: var(--color-accent);
}

.culture-card p {
  font-size: 14px;
  color: var(--color-muted);
  margin: 0;
}

@media (max-width: 1024px) {
  .content-block {
    grid-template-columns: 1fr;
  }

  .culture-grid {
    grid-template-columns: repeat(2, 1fr);
  }
}

@media (max-width: 768px) {
  .job-card {
    flex-direction: column;
    align-items: flex-start;
    gap: var(--spacing-md);
  }

  .job-meta {
    flex-wrap: wrap;
    gap: var(--spacing-sm);
  }

  .culture-grid {
    grid-template-columns: 1fr;
  }
}
</style>
