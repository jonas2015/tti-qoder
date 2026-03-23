<template>
  <div class="sustainability-page">
    <section class="page-hero">
      <div class="container">
        <h1>{{ $t('sustainability.title') }}</h1>
        <p>{{ $t('sustainability.subtitle') }}</p>
      </div>
    </section>

    <section class="section">
      <div class="container">
        <div class="content-block">
          <div class="content-text">
            <span class="section-label">{{ $t('sustainability.ourCommitment') }}</span>
            <h2>{{ $t('sustainability.sustainabilityAt') }}</h2>
            <p>{{ $t('sustainability.sustainabilityDesc') }}</p>
            <p>{{ $t('sustainability.threePillars') }}</p>
          </div>
          <div class="content-image">
            <img src="https://images.unsplash.com/photo-1473341304170-971dccb5ac1e?w=600" alt="Sustainability" />
          </div>
        </div>
      </div>
    </section>

    <section class="section section-gray">
      <div class="container">
        <div class="section-title">
          <span class="section-label">{{ $t('sustainability.goals') }}</span>
          <h2>{{ $t('sustainability.targets') }}</h2>
        </div>
        <div class="goals-grid">
          <div class="goal-card">
            <div class="goal-icon">🌱</div>
            <h3>{{ $t('sustainability.carbonNeutral') }}</h3>
            <p>{{ $t('sustainability.carbonDesc') }}</p>
          </div>
          <div class="goal-card">
            <div class="goal-icon">♻️</div>
            <h3>{{ $t('sustainability.zeroWaste') }}</h3>
            <p>{{ $t('sustainability.wasteDesc') }}</p>
          </div>
          <div class="goal-card">
            <div class="goal-icon">💧</div>
            <h3>{{ $t('sustainability.waterEfficiency') }}</h3>
            <p>{{ $t('sustainability.waterDesc') }}</p>
          </div>
          <div class="goal-card">
            <div class="goal-icon">📦</div>
            <h3>{{ $t('sustainability.sustainablePackaging') }}</h3>
            <p>{{ $t('sustainability.packagingDesc') }}</p>
          </div>
        </div>
      </div>
    </section>

    <section class="section">
      <div class="container">
        <div class="section-title">
          <h2>{{ $t('sustainability.initiatives') }}</h2>
        </div>
        <div class="initiatives-grid">
          <div class="initiative-card">
            <h4>{{ $t('sustainability.productDesign') }}</h4>
            <p>{{ $t('sustainability.productDesc') }}</p>
          </div>
          <div class="initiative-card">
            <h4>{{ $t('sustainability.energyEfficiency') }}</h4>
            <p>{{ $t('sustainability.energyDesc') }}</p>
          </div>
          <div class="initiative-card">
            <h4>{{ $t('sustainability.supplyChain') }}</h4>
            <p>{{ $t('sustainability.supplyDesc') }}</p>
          </div>
          <div class="initiative-card">
            <h4>{{ $t('sustainability.communityImpact') }}</h4>
            <p>{{ $t('sustainability.communityDesc') }}</p>
          </div>
        </div>
      </div>
    </section>

    <section class="section section-gray">
      <div class="container">
        <div class="section-title">
          <h2>{{ $t('sustainability.recognition') }}</h2>
        </div>
        <div class="recognition-grid">
          <div class="recognition-item">
            <span class="recognition-year">2025</span>
            <h4>AA Rating</h4>
            <p>{{ $t('sustainability.msciRating') }}</p>
          </div>
          <div class="recognition-item">
            <span class="recognition-year">2025</span>
            <h4>Prime Status</h4>
            <p>{{ $t('sustainability.issESG') }}</p>
          </div>
          <div class="recognition-item">
            <span class="recognition-year">2025</span>
            <h4>Bronze Medal</h4>
            <p>{{ $t('sustainability.ecovadis') }}</p>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
export default {
  name: 'Sustainability'
}
</script>

<style scoped>
.page-hero {
  background: linear-gradient(135deg, #2d5a27 0%, #1a3d15 100%);
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

.goals-grid {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: var(--spacing-lg);
}

.goal-card {
  background: var(--color-secondary);
  border-radius: 8px;
  padding: var(--spacing-xl);
  text-align: center;
  box-shadow: var(--shadow-md);
}

.goal-icon {
  font-size: 48px;
  margin-bottom: var(--spacing-md);
}

.goal-card h3 {
  margin-bottom: var(--spacing-sm);
}

.goal-card p {
  font-size: 14px;
  color: var(--color-muted);
  margin: 0;
}

.initiatives-grid {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: var(--spacing-lg);
}

.initiative-card {
  padding: var(--spacing-xl);
  background: var(--color-light-gray);
  border-radius: 8px;
}

.initiative-card h4 {
  margin-bottom: var(--spacing-md);
}

.initiative-card p {
  font-size: 14px;
  color: var(--color-muted);
  margin: 0;
}

.recognition-grid {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: var(--spacing-lg);
}

.recognition-item {
  text-align: center;
  padding: var(--spacing-xl);
  background: var(--color-secondary);
  border-radius: 8px;
  box-shadow: var(--shadow-sm);
}

.recognition-year {
  display: inline-block;
  font-size: 14px;
  font-weight: 600;
  color: var(--color-accent);
  margin-bottom: var(--spacing-sm);
}

.recognition-item h4 {
  margin-bottom: var(--spacing-xs);
}

.recognition-item p {
  color: var(--color-muted);
  margin: 0;
}

@media (max-width: 1024px) {
  .content-block {
    grid-template-columns: 1fr;
  }

  .goals-grid {
    grid-template-columns: repeat(2, 1fr);
  }

  .initiatives-grid {
    grid-template-columns: repeat(2, 1fr);
  }
}

@media (max-width: 768px) {
  .goals-grid,
  .initiatives-grid,
  .recognition-grid {
    grid-template-columns: 1fr;
  }
}
</style>
