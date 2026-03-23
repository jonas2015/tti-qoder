<template>
  <div class="brands-page">
    <section class="page-hero">
      <div class="container">
        <h1>{{ $t('brands.title') }}</h1>
        <p>{{ $t('brands.subtitle') }}</p>
      </div>
    </section>

    <section class="section">
      <div class="container">
        <div class="brands-grid">
          <div v-for="brand in brands" :key="brand.id" class="brand-card">
            <div class="brand-product-image">
              <img :src="brand.productImage" :alt="brand.name" @error="handleProductImageError" />
            </div>
            <div class="brand-logo">
              <img :src="brand.logo" :alt="brand.name" @error="handleImageError" />
            </div>
            <h3>{{ brand.name }}</h3>
            <span class="brand-category">{{ brand.category }}</span>
            <p class="brand-desc">{{ brand.description }}</p>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import api from '../services/api'

export default {
  name: 'Brands',
  data() {
    return {
      brands: []
    }
  },
  async mounted() {
    try {
      const response = await api.getBrands()
      this.brands = response.data
    } catch (error) {
      console.error('Error loading brands:', error)
    }
  },
  methods: {
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

.brands-grid {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: var(--spacing-lg);
}

.brand-card {
  background: var(--color-secondary);
  border: 1px solid var(--color-border);
  border-radius: 8px;
  padding: var(--spacing-lg);
  text-align: center;
  transition: all var(--transition-base);
  overflow: hidden;
}

.brand-card:hover {
  transform: translateY(-4px);
  box-shadow: var(--shadow-lg);
}

.brand-product-image {
  height: 140px;
  margin: calc(var(--spacing-lg) * -1) calc(var(--spacing-lg) * -1) var(--spacing-lg);
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

.brand-card h3 {
  margin-bottom: var(--spacing-xs);
}

.brand-category {
  display: inline-block;
  font-size: 12px;
  font-weight: 600;
  color: var(--color-accent);
  text-transform: uppercase;
  letter-spacing: 1px;
  margin-bottom: var(--spacing-md);
}

.brand-desc {
  font-size: 14px;
  color: var(--color-muted);
  margin: 0;
}

@media (max-width: 1024px) {
  .brands-grid {
    grid-template-columns: repeat(3, 1fr);
  }
}

@media (max-width: 768px) {
  .brands-grid {
    grid-template-columns: repeat(2, 1fr);
  }
}

@media (max-width: 480px) {
  .brands-grid {
    grid-template-columns: 1fr;
  }
}
</style>
