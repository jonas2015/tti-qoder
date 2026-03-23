<template>
  <footer class="footer">
    <div class="container">
      <div class="footer-grid">
        <div class="footer-brand">
          <div class="logo">
            <span class="logo-text">TTi</span>
            <span class="logo-sub">Group</span>
          </div>
          <p class="footer-desc">{{ $t('footer.desc') }}</p>
          <div class="social-links">
            <a href="#" class="social-link">LinkedIn</a>
            <a href="#" class="social-link">Twitter</a>
            <a href="#" class="social-link">YouTube</a>
          </div>
        </div>

        <div class="footer-links">
          <h4>{{ $t('nav.about') }}</h4>
          <ul>
            <li><router-link to="/about">{{ $t('nav.about') }}</router-link></li>
            <li><router-link to="/about">{{ $t('about.leadership') }}</router-link></li>
            <li><router-link to="/careers">{{ $t('nav.careers') }}</router-link></li>
            <li><router-link to="/news">{{ $t('nav.news') }}</router-link></li>
          </ul>
        </div>

        <div class="footer-links">
          <h4>{{ $t('nav.brands') }}</h4>
          <ul>
            <li><router-link to="/brands">Milwaukee</router-link></li>
            <li><router-link to="/brands">Ryobi</router-link></li>
            <li><router-link to="/brands">Hoover</router-link></li>
            <li><router-link to="/brands">Dyson</router-link></li>
            <li><router-link to="/brands">{{ $t('home.viewAllBrands') }}</router-link></li>
          </ul>
        </div>

        <div class="footer-links">
          <h4>{{ $t('nav.investors') }}</h4>
          <ul>
            <li><router-link to="/investors">{{ $t('investors.financialHighlights') }}</router-link></li>
            <li><router-link to="/investors">{{ $t('investors.stockInfo') }}</router-link></li>
            <li><router-link to="/investors">{{ $t('investors.secFilings') }}</router-link></li>
            <li><router-link to="/investors">{{ $t('investors.governance') }}</router-link></li>
          </ul>
        </div>

        <div class="footer-contact">
          <h4>{{ $t('nav.contact') }}</h4>
          <p>TTi Group Inc.</p>
          <p>5500 Executive Center Drive</p>
          <p>Charlotte, NC 28212</p>
          <p class="contact-email">info@ttigroup.com</p>
        </div>
      </div>

      <div class="footer-bottom">
        <p>&copy; 2026 TTi Group Inc. {{ $t('footer.rights') }}</p>
        <div class="footer-legal">
          <a href="#">{{ $t('footer.privacy') }}</a>
          <a href="#">{{ $t('footer.terms') }}</a>
          <a href="#">{{ $t('footer.cookie') }}</a>
        </div>
      </div>
    </div>
  </footer>
</template>

<script>
export default {
  name: 'AppFooter'
}
</script>

<style scoped>
.footer {
  background-color: var(--color-primary);
  color: var(--color-secondary);
  padding: var(--spacing-4xl) 0 var(--spacing-xl);
}

.footer-grid {
  display: grid;
  grid-template-columns: 2fr 1fr 1fr 1fr 1fr;
  gap: var(--spacing-2xl);
  margin-bottom: var(--spacing-3xl);
}

.footer-brand .logo {
  display: flex;
  align-items: baseline;
  font-size: 24px;
  font-weight: 700;
  margin-bottom: var(--spacing-md);
}

.footer-brand .logo-text {
  color: var(--color-secondary);
}

.footer-brand .logo-sub {
  color: var(--color-accent);
  font-weight: 400;
  margin-left: 2px;
}

.footer-desc {
  color: #999;
  font-size: 14px;
  line-height: 1.6;
  margin-bottom: var(--spacing-lg);
}

.social-links {
  display: flex;
  gap: var(--spacing-md);
}

.social-link {
  color: #999;
  font-size: 14px;
  transition: color var(--transition-fast);
}

.social-link:hover {
  color: var(--color-secondary);
}

.footer-links h4,
.footer-contact h4 {
  color: var(--color-secondary);
  font-size: 16px;
  font-weight: 600;
  margin-bottom: var(--spacing-lg);
}

.footer-links ul li {
  margin-bottom: var(--spacing-sm);
}

.footer-links a {
  color: #999;
  font-size: 14px;
  transition: color var(--transition-fast);
}

.footer-links a:hover {
  color: var(--color-secondary);
}

.footer-contact p {
  color: #999;
  font-size: 14px;
  margin-bottom: var(--spacing-xs);
}

.contact-email {
  margin-top: var(--spacing-md);
}

.footer-bottom {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding-top: var(--spacing-xl);
  border-top: 1px solid #333;
}

.footer-bottom p {
  color: #666;
  font-size: 14px;
  margin: 0;
}

.footer-legal {
  display: flex;
  gap: var(--spacing-lg);
}

.footer-legal a {
  color: #666;
  font-size: 14px;
  transition: color var(--transition-fast);
}

.footer-legal a:hover {
  color: var(--color-secondary);
}

@media (max-width: 1024px) {
  .footer-grid {
    grid-template-columns: repeat(3, 1fr);
  }

  .footer-brand {
    grid-column: span 3;
  }
}

@media (max-width: 768px) {
  .footer-grid {
    grid-template-columns: repeat(2, 1fr);
  }

  .footer-brand {
    grid-column: span 2;
  }

  .footer-bottom {
    flex-direction: column;
    gap: var(--spacing-md);
    text-align: center;
  }
}

@media (max-width: 480px) {
  .footer-grid {
    grid-template-columns: 1fr;
  }

  .footer-brand {
    grid-column: span 1;
  }
}
</style>
