<template>
  <div class="home">
    <!-- Hero Section -->
    <section class="hero">
      <div class="hero-background">
        <div class="hero-overlay"></div>
      </div>
      <div class="container">
        <div class="hero-content">
          <h1 class="hero-title">{{ $t('home.heroTitle') }}</h1>
          <p class="hero-subtitle">{{ $t('home.heroSubtitle') }}</p>
          <div class="hero-actions">
            <router-link to="/about" class="btn btn-primary">{{ $t('home.learnMore') }}</router-link>
            <router-link to="/brands" class="btn btn-outline">{{ $t('home.ourBrands') }}</router-link>
          </div>
        </div>
      </div>
    </section>

    <!-- About Preview -->
    <section class="section">
      <div class="container">
        <div class="about-preview">
          <div class="about-content">
            <span class="section-label">{{ $t('home.aboutLabel') }}</span>
            <h2>{{ $t('home.aboutTitle') }}</h2>
            <p>{{ $t('home.aboutDesc') }}</p>
            <div class="stats-grid">
              <div class="stat-item">
                <span class="stat-number">{{ companyInfo?.statistics?.employees?.toLocaleString() || '28,000' }}</span>
                <span class="stat-label">{{ $t('home.employees') }}</span>
              </div>
              <div class="stat-item">
                <span class="stat-number">{{ companyInfo?.statistics?.countries || '100' }}</span>
                <span class="stat-label">{{ $t('home.countries') }}</span>
              </div>
              <div class="stat-item">
                <span class="stat-number">{{ companyInfo?.statistics?.brands || '15' }}</span>
                <span class="stat-label">{{ $t('home.brands') }}</span>
              </div>
              <div class="stat-item">
                <span class="stat-number">{{ companyInfo?.statistics?.years || '40' }}+</span>
                <span class="stat-label">{{ $t('home.years') }}</span>
              </div>
            </div>
            <router-link to="/about" class="btn btn-outline">{{ $t('home.moreAboutUs') }}</router-link>
          </div>
          <div class="about-image">
            <img src="https://images.unsplash.com/photo-1581092160562-40aa08e78837?w=600" alt="TTi Group" />
          </div>
        </div>
      </div>
    </section>

    <!-- Brands Section -->
    <section class="section section-gray">
      <div class="container">
        <div class="section-title">
          <span class="section-label">{{ $t('home.ourBrands') }}</span>
          <h2>{{ $t('home.trustedBy') }}</h2>
          <p>{{ $t('home.brandsDesc') }}</p>
        </div>
        <div class="brands-grid">
          <div v-for="brand in brands" :key="brand.id" class="brand-card">
            <div class="brand-product-image">
              <img :src="brand.productImage" :alt="brand.name" @error="handleProductImageError" />
            </div>
            <div class="brand-logo">
              <img :src="brand.logo" :alt="brand.name" @error="handleImageError" />
            </div>
            <span class="brand-name">{{ brand.name }}</span>
            <span class="brand-category">{{ brand.category }}</span>
          </div>
        </div>
        <div class="section-cta">
          <router-link to="/brands" class="btn btn-primary">{{ $t('home.viewAllBrands') }}</router-link>
        </div>
      </div>
    </section>

    <!-- News Section -->
    <section class="section">
      <div class="container">
        <div class="section-title">
          <span class="section-label">{{ $t('home.latestNews') }}</span>
          <h2>{{ $t('home.recentUpdates') }}</h2>
        </div>
        <div class="news-grid">
          <article v-for="article in news" :key="article.id" class="news-card">
            <div class="news-image">
              <img :src="article.imageUrl" :alt="article.title" />
              <span class="news-category">{{ article.category }}</span>
            </div>
            <div class="news-content">
              <span class="news-date">{{ formatDate(article.date) }}</span>
              <h3>{{ article.title }}</h3>
              <p>{{ article.excerpt }}</p>
              <router-link to="/news" class="news-link">{{ $t('home.readMore') }}</router-link>
            </div>
          </article>
        </div>
        <div class="section-cta">
          <router-link to="/news" class="btn btn-outline">{{ $t('home.viewAllNews') }}</router-link>
        </div>
      </div>
    </section>

    <!-- CTA Section -->
    <section class="cta-section">
      <div class="container">
        <div class="cta-content">
          <h2>{{ $t('home.joinOurTeam') }}</h2>
          <p>{{ $t('home.careersDesc') }}</p>
          <router-link to="/careers" class="btn btn-primary">{{ $t('home.exploreCareers') }}</router-link>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import api from '../services/api'

export default {
  name: 'Home',
  data() {
    return {
      brands: [],
      news: [],
      companyInfo: null
    }
  },
  async mounted() {
    await this.loadData()
  },
  methods: {
    async loadData() {
      try {
        const [brandsRes, newsRes, aboutRes] = await Promise.all([
          api.getBrands(),
          api.getNews(),
          api.getAbout()
        ])
        this.brands = brandsRes.data.slice(0, 8)
        this.news = newsRes.data.slice(0, 3)
        this.companyInfo = aboutRes.data
      } catch (error) {
        console.error('Error loading data:', error)
      }
    },
    formatDate(dateStr) {
      const date = new Date(dateStr)
      return date.toLocaleDateString('en-US', { year: 'numeric', month: 'long', day: 'numeric' })
    },
    handleImageError(e) {
      e.target.style.display = 'none'
    },
    handleProductImageError(e) {
      e.target.style.display = 'none'
    }
  }
}
</script>

<style scoped>
/* Hero */
.hero {
  position: relative;
  min-height: 100vh;
  display: flex;
  align-items: center;
  padding-top: 80px;
}

.hero-background {
  position: absolute;
  inset: 0;
  background: linear-gradient(135deg, #1a1a1a 0%, #2d2d2d 100%);
}

.hero-overlay {
  position: absolute;
  inset: 0;
  background: url('https://images.unsplash.com/photo-1504148455328-c376907d081c?w=1920') center/cover;
  opacity: 0.3;
}

.hero-content {
  position: relative;
  max-width: 700px;
  color: var(--color-secondary);
}

.hero-title {
  color: var(--color-secondary);
  margin-bottom: var(--spacing-lg);
  animation: fadeIn 0.8s ease;
}

.hero-subtitle {
  font-size: 20px;
  color: rgba(255, 255, 255, 0.8);
  margin-bottom: var(--spacing-xl);
  animation: fadeIn 0.8s ease 0.2s both;
}

.hero-actions {
  display: flex;
  gap: var(--spacing-md);
  animation: fadeIn 0.8s ease 0.4s both;
}

.hero-actions .btn-outline {
  border-color: var(--color-secondary);
  color: var(--color-secondary);
}

.hero-actions .btn-outline:hover {
  background-color: var(--color-secondary);
  color: var(--color-primary);
}

/* Section Label */
.section-label {
  display: inline-block;
  font-size: 14px;
  font-weight: 600;
  color: var(--color-accent);
  text-transform: uppercase;
  letter-spacing: 1px;
  margin-bottom: var(--spacing-sm);
}

/* About Preview */
.about-preview {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: var(--spacing-3xl);
  align-items: center;
}

.about-content h2 {
  margin-bottom: var(--spacing-lg);
}

.stats-grid {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: var(--spacing-lg);
  margin: var(--spacing-xl) 0;
}

.stat-item {
  text-align: center;
}

.stat-number {
  display: block;
  font-size: 36px;
  font-weight: 700;
  color: var(--color-accent);
}

.stat-label {
  font-size: 14px;
  color: var(--color-muted);
}

.about-image {
  border-radius: 8px;
  overflow: hidden;
  box-shadow: var(--shadow-lg);
}

.about-image img {
  width: 100%;
  height: 400px;
  object-fit: cover;
}

/* Brands Grid */
.brands-grid {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: var(--spacing-lg);
}

.brand-card {
  background: var(--color-secondary);
  border-radius: 8px;
  padding: var(--spacing-xl);
  text-align: center;
  box-shadow: var(--shadow-sm);
  transition: all var(--transition-base);
  border: 1px solid var(--color-border);
}

.brand-card:hover {
  transform: translateY(-4px);
  box-shadow: var(--shadow-md);
}

.brand-product-image {
  height: 100px;
  margin: -24px -24px 16px;
  overflow: hidden;
  background: #f5f5f5;
}

.brand-product-image img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.brand-logo {
  height: 60px;
  display: flex;
  align-items: center;
  justify-content: center;
  margin-bottom: var(--spacing-md);
}

.brand-logo img {
  max-height: 50px;
  max-width: 100px;
  object-fit: contain;
}

.brand-name {
  display: block;
  font-weight: 600;
  font-size: 18px;
  margin-bottom: var(--spacing-xs);
}

.brand-category {
  font-size: 14px;
  color: var(--color-muted);
}

/* News Grid */
.news-grid {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: var(--spacing-lg);
}

.news-card {
  background: var(--color-secondary);
  border-radius: 8px;
  overflow: hidden;
  box-shadow: var(--shadow-md);
  transition: all var(--transition-base);
}

.news-card:hover {
  transform: translateY(-4px);
  box-shadow: var(--shadow-lg);
}

.news-image {
  position: relative;
  height: 200px;
  overflow: hidden;
}

.news-image img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.news-category {
  position: absolute;
  top: var(--spacing-md);
  left: var(--spacing-md);
  background: var(--color-accent);
  color: var(--color-secondary);
  padding: var(--spacing-xs) var(--spacing-sm);
  font-size: 12px;
  font-weight: 600;
  border-radius: 4px;
}

.news-content {
  padding: var(--spacing-lg);
}

.news-date {
  font-size: 14px;
  color: var(--color-muted);
}

.news-content h3 {
  font-size: 18px;
  margin: var(--spacing-sm) 0;
  line-height: 1.4;
}

.news-content p {
  font-size: 14px;
  color: var(--color-muted);
  margin-bottom: var(--spacing-md);
}

.news-link {
  font-size: 14px;
  font-weight: 500;
  color: var(--color-accent);
}

.news-link:hover {
  text-decoration: underline;
}

/* CTA Section */
.cta-section {
  background: linear-gradient(135deg, var(--color-primary) 0%, #2d2d2d 100%);
  padding: var(--spacing-4xl) 0;
  text-align: center;
}

.cta-content {
  color: var(--color-secondary);
}

.cta-content h2 {
  color: var(--color-secondary);
  margin-bottom: var(--spacing-md);
}

.cta-content p {
  color: rgba(255, 255, 255, 0.8);
  margin-bottom: var(--spacing-xl);
  max-width: 500px;
  margin-left: auto;
  margin-right: auto;
}

.section-cta {
  text-align: center;
  margin-top: var(--spacing-2xl);
}

/* Responsive */
@media (max-width: 1024px) {
  .about-preview {
    grid-template-columns: 1fr;
  }

  .about-image {
    order: -1;
  }

  .brands-grid {
    grid-template-columns: repeat(3, 1fr);
  }

  .news-grid {
    grid-template-columns: repeat(2, 1fr);
  }
}

@media (max-width: 768px) {
  .hero {
    min-height: 70vh;
  }

  .hero-title {
    font-size: 36px;
  }

  .hero-subtitle {
    font-size: 18px;
  }

  .stats-grid {
    grid-template-columns: repeat(2, 1fr);
  }

  .brands-grid {
    grid-template-columns: repeat(2, 1fr);
  }

  .news-grid {
    grid-template-columns: 1fr;
  }
}
</style>
