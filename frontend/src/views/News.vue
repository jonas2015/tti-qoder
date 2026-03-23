<template>
  <div class="news-page">
    <section class="page-hero">
      <div class="container">
        <h1>{{ $t('news.title') }}</h1>
        <p>{{ $t('news.subtitle') }}</p>
      </div>
    </section>

    <section class="section">
      <div class="container">
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
              <a href="#" class="news-link">{{ $t('home.readMore') }}</a>
            </div>
          </article>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import api from '../services/api'

export default {
  name: 'News',
  data() {
    return {
      news: []
    }
  },
  async mounted() {
    try {
      const response = await api.getNews()
      this.news = response.data
    } catch (error) {
      console.error('Error loading news:', error)
    }
  },
  methods: {
    formatDate(dateStr) {
      const date = new Date(dateStr)
      return date.toLocaleDateString('en-US', { year: 'numeric', month: 'long', day: 'numeric' })
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
  height: 220px;
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
  padding: var(--spacing-xl);
}

.news-date {
  font-size: 14px;
  color: var(--color-muted);
}

.news-content h3 {
  font-size: 20px;
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

@media (max-width: 1024px) {
  .news-grid {
    grid-template-columns: repeat(2, 1fr);
  }
}

@media (max-width: 768px) {
  .news-grid {
    grid-template-columns: 1fr;
  }
}
</style>
