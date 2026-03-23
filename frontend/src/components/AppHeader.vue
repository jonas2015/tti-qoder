<template>
  <header class="header" :class="{ 'header-scrolled': isScrolled }">
    <div class="container">
      <div class="header-content">
        <router-link to="/" class="logo">
          <span class="logo-text">TTi</span>
          <span class="logo-sub">Group</span>
        </router-link>

        <nav class="nav-desktop">
          <router-link to="/" class="nav-link">{{ $t('nav.home') }}</router-link>
          <router-link to="/about" class="nav-link">{{ $t('nav.about') }}</router-link>
          <router-link to="/brands" class="nav-link">{{ $t('nav.brands') }}</router-link>
          <router-link to="/investors" class="nav-link">{{ $t('nav.investors') }}</router-link>
          <router-link to="/sustainability" class="nav-link">{{ $t('nav.sustainability') }}</router-link>
          <router-link to="/careers" class="nav-link">{{ $t('nav.careers') }}</router-link>
          <router-link to="/news" class="nav-link">{{ $t('nav.news') }}</router-link>
          <router-link to="/contact" class="nav-link">{{ $t('nav.contact') }}</router-link>
        </nav>

        <div class="header-actions">
          <div class="lang-switcher">
            <button
              class="lang-btn"
              :class="{ active: locale === 'en' }"
              @click="setLang('en')"
            >
              EN
            </button>
            <button
              class="lang-btn"
              :class="{ active: locale === 'cn' }"
              @click="setLang('cn')"
            >
              中文
            </button>
          </div>
          <button class="menu-toggle" @click="toggleMobileMenu">
            <span></span>
            <span></span>
            <span></span>
          </button>
        </div>
      </div>
    </div>

    <transition name="slide">
      <nav class="nav-mobile" v-if="mobileMenuOpen">
        <router-link to="/" class="nav-link" @click="closeMobileMenu">{{ $t('nav.home') }}</router-link>
        <router-link to="/about" class="nav-link" @click="closeMobileMenu">{{ $t('nav.about') }}</router-link>
        <router-link to="/brands" class="nav-link" @click="closeMobileMenu">{{ $t('nav.brands') }}</router-link>
        <router-link to="/investors" class="nav-link" @click="closeMobileMenu">{{ $t('nav.investors') }}</router-link>
        <router-link to="/sustainability" class="nav-link" @click="closeMobileMenu">{{ $t('nav.sustainability') }}</router-link>
        <router-link to="/careers" class="nav-link" @click="closeMobileMenu">{{ $t('nav.careers') }}</router-link>
        <router-link to="/news" class="nav-link" @click="closeMobileMenu">{{ $t('nav.news') }}</router-link>
        <router-link to="/contact" class="nav-link" @click="closeMobileMenu">{{ $t('nav.contact') }}</router-link>
      </nav>
    </transition>
  </header>
</template>

<script>
import { useI18n } from 'vue-i18n'

export default {
  name: 'AppHeader',
  setup() {
    const { locale } = useI18n()
    return { locale }
  },
  data() {
    return {
      isScrolled: false,
      mobileMenuOpen: false
    }
  },
  mounted() {
    window.addEventListener('scroll', this.handleScroll)
  },
  beforeUnmount() {
    window.removeEventListener('scroll', this.handleScroll)
  },
  methods: {
    handleScroll() {
      this.isScrolled = window.scrollY > 50
    },
    toggleMobileMenu() {
      this.mobileMenuOpen = !this.mobileMenuOpen
    },
    closeMobileMenu() {
      this.mobileMenuOpen = false
    },
    setLang(lang) {
      this.locale = lang
      localStorage.setItem('locale', lang)
    }
  }
}
</script>

<style scoped>
.header {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  z-index: 1000;
  background-color: var(--color-secondary);
  transition: all var(--transition-base);
  border-bottom: 1px solid transparent;
}

.header-scrolled {
  box-shadow: var(--shadow-md);
  border-bottom: 1px solid var(--color-border);
}

.header-content {
  display: flex;
  align-items: center;
  justify-content: space-between;
  height: 80px;
}

.logo {
  display: flex;
  align-items: baseline;
  font-size: 28px;
  font-weight: 700;
}

.logo-text {
  color: var(--color-primary);
}

.logo-sub {
  color: var(--color-accent);
  font-weight: 400;
  margin-left: 2px;
}

.nav-desktop {
  display: flex;
  align-items: center;
  gap: var(--spacing-xl);
}

.nav-link {
  font-size: 15px;
  font-weight: 500;
  color: var(--color-primary);
  position: relative;
  padding: var(--spacing-sm) 0;
}

.nav-link::after {
  content: '';
  position: absolute;
  bottom: 0;
  left: 0;
  width: 0;
  height: 2px;
  background-color: var(--color-accent);
  transition: width var(--transition-base);
}

.nav-link:hover::after,
.nav-link.router-link-active::after {
  width: 100%;
}

.header-actions {
  display: flex;
  align-items: center;
  gap: var(--spacing-md);
}

.lang-switcher {
  display: flex;
  gap: 4px;
}

.lang-btn {
  padding: 6px 12px;
  font-size: 13px;
  font-weight: 500;
  color: var(--color-primary);
  border: 1px solid var(--color-border);
  background: transparent;
  transition: all var(--transition-fast);
  cursor: pointer;
}

.lang-btn:first-child {
  border-radius: 4px 0 0 4px;
}

.lang-btn:last-child {
  border-radius: 0 4px 4px 0;
}

.lang-btn:hover {
  background-color: var(--color-light-gray);
}

.lang-btn.active {
  background-color: var(--color-accent);
  border-color: var(--color-accent);
  color: var(--color-secondary);
}

.menu-toggle {
  display: none;
  flex-direction: column;
  gap: 5px;
  padding: var(--spacing-sm);
}

.menu-toggle span {
  display: block;
  width: 24px;
  height: 2px;
  background-color: var(--color-primary);
  transition: all var(--transition-fast);
}

.nav-mobile {
  display: none;
  flex-direction: column;
  padding: var(--spacing-lg);
  background-color: var(--color-secondary);
  border-top: 1px solid var(--color-border);
}

.nav-mobile .nav-link {
  padding: var(--spacing-md) 0;
  border-bottom: 1px solid var(--color-border);
}

/* Mobile Styles */
@media (max-width: 1024px) {
  .nav-desktop {
    display: none;
  }

  .menu-toggle {
    display: flex;
  }

  .nav-mobile {
    display: flex;
  }
}

/* Transitions */
.slide-enter-active,
.slide-leave-active {
  transition: all 0.3s ease;
}

.slide-enter-from,
.slide-leave-to {
  opacity: 0;
  transform: translateY(-10px);
}
</style>
