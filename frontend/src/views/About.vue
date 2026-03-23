<template>
  <div class="about-page">
    <!-- Hero -->
    <section class="page-hero">
      <div class="container">
        <h1>{{ $t('about.title') }}</h1>
        <p>{{ $t('about.subtitle') }}</p>
      </div>
    </section>

    <!-- Overview -->
    <section class="section">
      <div class="container">
        <div class="content-block">
          <div class="content-text">
            <span class="section-label">{{ $t('about.overview') }}</span>
            <h2>{{ $t('about.globalLeader') }}</h2>
            <p>{{ companyInfo?.description || $t('about.description') }}</p>
            <p>{{ companyInfo?.history || $t('about.history') }}</p>
          </div>
          <div class="content-image">
            <img src="https://images.unsplash.com/photo-1486406146926-c627a92ad1ab?w=600" alt="TTi Group HQ" />
          </div>
        </div>
      </div>
    </section>

    <!-- Stats -->
    <section class="section section-gray">
      <div class="container">
        <div class="stats-row">
          <div class="stat-box">
            <span class="stat-value">{{ companyInfo?.statistics?.employees?.toLocaleString() || '28,000' }}</span>
            <span class="stat-label">{{ $t('about.stats.employees') }}</span>
          </div>
          <div class="stat-box">
            <span class="stat-value">{{ companyInfo?.statistics?.countries || '100' }}</span>
            <span class="stat-label">{{ $t('about.stats.countries') }}</span>
          </div>
          <div class="stat-box">
            <span class="stat-value">{{ companyInfo?.statistics?.brands || '15' }}</span>
            <span class="stat-label">{{ $t('about.stats.globalBrands') }}</span>
          </div>
          <div class="stat-box">
            <span class="stat-value">{{ companyInfo?.statistics?.years || '40' }}+</span>
            <span class="stat-label">{{ $t('about.stats.yearsExcellence') }}</span>
          </div>
          <div class="stat-box">
            <span class="stat-value">{{ companyInfo?.statistics?.revenue || '$8.2B' }}</span>
            <span class="stat-label">{{ $t('about.stats.annualRevenue') }}</span>
          </div>
        </div>
      </div>
    </section>

    <!-- Mission & Vision -->
    <section class="section">
      <div class="container">
        <div class="mission-vision">
          <div class="mv-card">
            <h3>{{ $t('about.vision') }}</h3>
            <p>{{ companyInfo?.vision || $t('about.visionText') }}</p>
          </div>
          <div class="mv-card">
            <h3>{{ $t('about.mission') }}</h3>
            <p>{{ companyInfo?.mission || $t('about.missionText') }}</p>
          </div>
        </div>
      </div>
    </section>

    <!-- Leadership -->
    <section class="section section-gray">
      <div class="container">
        <div class="section-title">
          <span class="section-label">{{ $t('about.leadership') }}</span>
          <h2>{{ $t('about.executiveTeam') }}</h2>
        </div>
        <div class="leadership-grid">
          <div v-for="leader in companyInfo?.leadership || []" :key="leader.name" class="leader-card">
            <div class="leader-image">
              <img :src="leader.image" :alt="leader.name" />
            </div>
            <h4>{{ leader.name }}</h4>
            <span class="leader-position">{{ leader.position }}</span>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import api from '../services/api'

export default {
  name: 'About',
  data() {
    return {
      companyInfo: null
    }
  },
  async mounted() {
    try {
      const response = await api.getAbout()
      this.companyInfo = response.data
    } catch (error) {
      console.error('Error loading company info:', error)
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
  max-width: 600px;
  margin: 0 auto;
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

.content-text p {
  color: var(--color-muted);
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

.stats-row {
  display: grid;
  grid-template-columns: repeat(5, 1fr);
  gap: var(--spacing-lg);
}

.stat-box {
  text-align: center;
  padding: var(--spacing-xl);
  background: var(--color-secondary);
  border-radius: 8px;
  box-shadow: var(--shadow-sm);
}

.stat-value {
  display: block;
  font-size: 36px;
  font-weight: 700;
  color: var(--color-accent);
  margin-bottom: var(--spacing-xs);
}

.stat-label {
  font-size: 14px;
  color: var(--color-muted);
}

.mission-vision {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: var(--spacing-xl);
}

.mv-card {
  padding: var(--spacing-2xl);
  background: var(--color-light-gray);
  border-radius: 8px;
  border-left: 4px solid var(--color-accent);
}

.mv-card h3 {
  margin-bottom: var(--spacing-md);
}

.mv-card p {
  color: var(--color-muted);
  margin: 0;
}

.leadership-grid {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: var(--spacing-xl);
}

.leader-card {
  text-align: center;
}

.leader-image {
  width: 150px;
  height: 150px;
  border-radius: 50%;
  overflow: hidden;
  margin: 0 auto var(--spacing-md);
}

.leader-image img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.leader-position {
  color: var(--color-muted);
  font-size: 14px;
}

@media (max-width: 1024px) {
  .content-block {
    grid-template-columns: 1fr;
  }

  .stats-row {
    grid-template-columns: repeat(3, 1fr);
  }

  .leadership-grid {
    grid-template-columns: repeat(2, 1fr);
  }
}

@media (max-width: 768px) {
  .stats-row {
    grid-template-columns: repeat(2, 1fr);
  }

  .mission-vision {
    grid-template-columns: 1fr;
  }

  .leadership-grid {
    grid-template-columns: 1fr;
  }
}
</style>
