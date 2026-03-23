<template>
  <div class="investors-page">
    <section class="page-hero">
      <div class="container">
        <h1>{{ $t('investors.title') }}</h1>
        <p>{{ $t('investors.subtitle') }}</p>
      </div>
    </section>

    <section class="section">
      <div class="container">
        <div class="section-title">
          <span class="section-label">{{ $t('investors.financialHighlights') }}</span>
          <h2>{{ $t('investors.performance') }}</h2>
        </div>
        <div class="financial-grid">
          <div class="financial-card">
            <span class="financial-value">$8.2B</span>
            <span class="financial-label">{{ $t('investors.revenue') }}</span>
            <span class="financial-change positive">+12% {{ $t('investors.yoy') }}</span>
          </div>
          <div class="financial-card">
            <span class="financial-value">$1.4B</span>
            <span class="financial-label">{{ $t('investors.netIncome') }}</span>
            <span class="financial-change positive">+18% {{ $t('investors.yoy') }}</span>
          </div>
          <div class="financial-card">
            <span class="financial-value">$5.2B</span>
            <span class="financial-label">{{ $t('investors.marketCap') }}</span>
            <span class="financial-change positive">+15% {{ $t('investors.yoy') }}</span>
          </div>
          <div class="financial-card">
            <span class="financial-value">2.8</span>
            <span class="financial-label">{{ $t('investors.eps') }}</span>
            <span class="financial-change positive">+20% {{ $t('investors.yoy') }}</span>
          </div>
        </div>
      </div>
    </section>

    <section class="section section-gray">
      <div class="container">
        <div class="section-title">
          <h2>{{ $t('investors.stockInfo') }}</h2>
        </div>
        <div class="stock-info">
          <div class="stock-price">
            <span class="stock-symbol">{{ $t('investors.stockSymbol') }}</span>
            <span class="stock-value">$142.50</span>
            <span class="stock-change positive">+2.34 (+1.67%)</span>
          </div>
          <div class="stock-details">
            <div class="stock-row">
              <span>{{ $t('investors.exchange') }}</span>
              <span>NYSE</span>
            </div>
            <div class="stock-row">
              <span>{{ $t('investors.weekRange') }}</span>
              <span>$118.25 - $156.80</span>
            </div>
            <div class="stock-row">
              <span>{{ $t('investors.marketCap') }}</span>
              <span>$52.4B</span>
            </div>
            <div class="stock-row">
              <span>{{ $t('investors.peRatio') }}</span>
              <span>24.5</span>
            </div>
          </div>
        </div>
      </div>
    </section>

    <section class="section">
      <div class="container">
        <div class="section-title">
          <span class="section-label">{{ $t('investors.reports') }}</span>
          <h2>{{ $t('investors.secFilings') }}</h2>
        </div>
        <div class="reports-list">
          <div class="report-item" v-for="(report, index) in reports" :key="index">
            <div class="report-header" @click="toggleReport(index)">
              <div class="report-icon">PDF</div>
              <div class="report-info">
                <h4>{{ report.title }}</h4>
                <span class="report-date">{{ report.date }}</span>
              </div>
              <span class="toggle-icon" :class="{ expanded: expandedReports.includes(index) }">▼</span>
            </div>
            <div class="report-content" v-show="expandedReports.includes(index)">
              <div class="report-details">
                <h5>{{ report.detailsTitle }}</h5>
                <p>{{ report.description }}</p>
                <div class="report-stats" v-if="report.stats">
                  <div class="stat" v-for="(value, key) in report.stats" :key="key">
                    <span class="stat-label">{{ key }}</span>
                    <span class="stat-value">{{ value }}</span>
                  </div>
                </div>
                <div class="report-sections" v-if="report.sections">
                  <div class="section-item" v-for="(section, sIndex) in report.sections" :key="sIndex">
                    <h6>{{ section.title }}</h6>
                    <p>{{ section.content }}</p>
                  </div>
                </div>
                <a href="#" class="btn btn-sm btn-outline download-btn">{{ $t('investors.download') }}</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <section class="section section-gray">
      <div class="container">
        <div class="section-title">
          <h2>{{ $t('investors.governance') }}</h2>
        </div>
        <div class="governance-grid">
          <div class="governance-card">
            <h4>{{ $t('investors.boardDirectors') }}</h4>
            <p>{{ $t('investors.boardDesc') }}</p>
            <a href="#" class="governance-link">{{ $t('investors.learnMore') }}</a>
          </div>
          <div class="governance-card">
            <h4>{{ $t('investors.committeeInfo') }}</h4>
            <p>{{ $t('investors.committeeDesc') }}</p>
            <a href="#" class="governance-link">{{ $t('investors.learnMore') }}</a>
          </div>
          <div class="governance-card">
            <h4>{{ $t('investors.governanceDocs') }}</h4>
            <p>{{ $t('investors.docsDesc') }}</p>
            <a href="#" class="governance-link">{{ $t('investors.learnMore') }}</a>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
export default {
  name: 'Investors',
  data() {
    return {
      expandedReports: [],
      reports: [
        {
          title: '2025 Annual Report',
          date: 'February 2026',
          detailsTitle: 'Annual Performance Summary',
          description: 'Comprehensive review of TTi Group\'s financial performance, strategic initiatives, and future outlook for fiscal year 2025.',
          stats: {
            'Revenue': '$8.2B',
            'Net Income': '$1.4B',
            'EPS': '$2.80',
            'YoY Growth': '+12%'
          },
          sections: [
            { title: 'CEO Message', content: '2025 marked another year of exceptional growth and innovation for TTi Group. Our commitment to quality and customer satisfaction drove record-breaking results across all business segments.' },
            { title: 'Business Overview', content: 'Our power tools segment grew 15% driven by new product launches in the Milwaukee and Ryobi brands. The floor care division achieved 8% growth through expansion into emerging markets.' },
            { title: 'Financial Review', content: 'Gross margin improved to 38.5% through operational efficiencies and strategic pricing. Operating cash flow reached $1.8B, representing 22% of revenue.' }
          ]
        },
        {
          title: 'Q4 2025 Earnings Release',
          date: 'January 2026',
          detailsTitle: 'Fourth Quarter Results',
          description: 'Fourth quarter financial results and operational highlights for the period ended December 31, 2025.',
          stats: {
            'Q4 Revenue': '$2.1B',
            'Q4 Net Income': '$365M',
            'Q4 EPS': '$0.72',
            'Q4 Growth': '+14%'
          },
          sections: [
            { title: 'Quarterly Highlights', content: 'Q4 saw strong momentum with holiday season sales exceeding expectations. New product launches contributed to market share gains in key categories.' },
            { title: 'Segment Performance', content: 'Power Tools segment revenue grew 16% year-over-year. Floor Care delivered 9% growth with successful premium product introductions.' }
          ]
        },
        {
          title: 'Q3 2025 Quarterly Report',
          date: 'October 2025',
          detailsTitle: 'Third Quarter Analysis',
          description: 'Detailed analysis of third quarter financial performance and business updates.',
          stats: {
            'Q3 Revenue': '$2.0B',
            'Q3 Net Income': '$340M',
            'Q3 EPS': '$0.68',
            'Q3 Growth': '+11%'
          },
          sections: [
            { title: 'Operational Updates', content: 'Successfully completed integration of recent acquisitions. Expanded manufacturing capacity in Asia to meet growing demand.' },
            { title: 'Market Position', content: 'Maintained leadership position in professional power tools. Gained market share in residential segment through Ryobi brand expansion.' }
          ]
        },
        {
          title: '2025 Sustainability Report',
          date: 'August 2025',
          detailsTitle: 'Environmental, Social & Governance Report',
          description: 'Comprehensive report on TTi Group\'s sustainability initiatives, environmental impact, and social responsibility programs.',
          stats: {
            'Carbon Reduction': '-25%',
            'Renewable Energy': '45%',
            'Waste Diverted': '82%',
            'Supplier Audits': '100%'
          },
          sections: [
            { title: 'Environmental Goals', content: 'On track to achieve carbon neutrality by 2030. Invested $50M in renewable energy projects across global facilities.' },
            { title: 'Social Impact', content: 'Achieved 40% diversity in leadership positions. Expanded employee wellness programs to all global locations.' },
            { title: 'Governance', content: 'Enhanced board diversity with 45% independent directors. Implemented enhanced ESG oversight at board level.' }
          ]
        }
      ]
    }
  },
  methods: {
    toggleReport(index) {
      const idx = this.expandedReports.indexOf(index)
      if (idx > -1) {
        this.expandedReports.splice(idx, 1)
      } else {
        this.expandedReports.push(index)
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

.financial-grid {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: var(--spacing-lg);
}

.financial-card {
  background: var(--color-secondary);
  border-radius: 8px;
  padding: var(--spacing-xl);
  text-align: center;
  box-shadow: var(--shadow-md);
}

.financial-value {
  display: block;
  font-size: 42px;
  font-weight: 700;
  color: var(--color-primary);
}

.financial-label {
  display: block;
  font-size: 14px;
  color: var(--color-muted);
  margin-bottom: var(--spacing-sm);
}

.financial-change {
  display: inline-block;
  font-size: 14px;
  font-weight: 500;
  padding: var(--spacing-xs) var(--spacing-sm);
  border-radius: 4px;
}

.financial-change.positive {
  color: #28a745;
  background: rgba(40, 167, 69, 0.1);
}

.stock-info {
  background: var(--color-secondary);
  border-radius: 8px;
  padding: var(--spacing-xl);
  box-shadow: var(--shadow-md);
}

.stock-price {
  display: flex;
  align-items: baseline;
  gap: var(--spacing-md);
  margin-bottom: var(--spacing-xl);
  padding-bottom: var(--spacing-xl);
  border-bottom: 1px solid var(--color-border);
}

.stock-symbol {
  font-size: 24px;
  font-weight: 700;
}

.stock-value {
  font-size: 48px;
  font-weight: 700;
}

.stock-change {
  font-size: 18px;
  font-weight: 500;
}

.stock-change.positive {
  color: #28a745;
}

.stock-details {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: var(--spacing-lg);
}

.stock-row {
  display: flex;
  flex-direction: column;
  gap: var(--spacing-xs);
}

.stock-row span:first-child {
  font-size: 14px;
  color: var(--color-muted);
}

.stock-row span:last-child {
  font-size: 16px;
  font-weight: 500;
}

.reports-list {
  display: flex;
  flex-direction: column;
  gap: var(--spacing-md);
}

.report-item {
  display: flex;
  align-items: center;
  gap: var(--spacing-lg);
  background: var(--color-secondary);
  border: 1px solid var(--color-border);
  border-radius: 8px;
  padding: var(--spacing-lg);
}

.report-icon {
  width: 50px;
  height: 50px;
  display: flex;
  align-items: center;
  justify-content: center;
  background: var(--color-accent);
  color: var(--color-secondary);
  font-size: 12px;
  font-weight: 700;
  border-radius: 4px;
}

.report-info {
  flex: 1;
}

.report-info h4 {
  margin-bottom: var(--spacing-xs);
}

.report-date {
  font-size: 14px;
  color: var(--color-muted);
}

.report-header {
  display: flex;
  align-items: center;
  gap: var(--spacing-lg);
  cursor: pointer;
  width: 100%;
}

.report-header .report-icon {
  flex-shrink: 0;
}

.report-header .report-info {
  flex: 1;
  text-align: left;
}

.toggle-icon {
  font-size: 12px;
  color: var(--color-muted);
  transition: transform var(--transition-fast);
}

.toggle-icon.expanded {
  transform: rotate(180deg);
}

.report-content {
  width: 100%;
  padding-top: var(--spacing-lg);
  margin-top: var(--spacing-lg);
  border-top: 1px solid var(--color-border);
}

.report-details h5 {
  margin-bottom: var(--spacing-md);
  color: var(--color-accent);
}

.report-details > p {
  color: var(--color-muted);
  margin-bottom: var(--spacing-lg);
}

.report-stats {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: var(--spacing-md);
  margin-bottom: var(--spacing-lg);
  padding: var(--spacing-md);
  background: var(--color-light-gray);
  border-radius: 4px;
}

.stat {
  display: flex;
  flex-direction: column;
  gap: var(--spacing-xs);
}

.stat-label {
  font-size: 12px;
  color: var(--color-muted);
}

.stat-value {
  font-size: 16px;
  font-weight: 600;
}

.report-sections {
  display: flex;
  flex-direction: column;
  gap: var(--spacing-md);
  margin-bottom: var(--spacing-lg);
}

.section-item {
  padding: var(--spacing-md);
  background: var(--color-light-gray);
  border-radius: 4px;
}

.section-item h6 {
  margin-bottom: var(--spacing-xs);
  color: var(--color-primary);
}

.section-item p {
  font-size: 14px;
  color: var(--color-muted);
  margin: 0;
}

.download-btn {
  display: inline-block;
  margin-top: var(--spacing-md);
}

.governance-grid {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: var(--spacing-lg);
}

.governance-card {
  background: var(--color-secondary);
  border-radius: 8px;
  padding: var(--spacing-xl);
  box-shadow: var(--shadow-sm);
}

.governance-card h4 {
  margin-bottom: var(--spacing-md);
}

.governance-card p {
  color: var(--color-muted);
  margin-bottom: var(--spacing-lg);
}

.governance-link {
  color: var(--color-accent);
  font-weight: 500;
}

@media (max-width: 1024px) {
  .financial-grid {
    grid-template-columns: repeat(2, 1fr);
  }

  .stock-details {
    grid-template-columns: repeat(2, 1fr);
  }

  .governance-grid {
    grid-template-columns: repeat(2, 1fr);
  }
}

@media (max-width: 768px) {
  .financial-grid {
    grid-template-columns: 1fr;
  }

  .stock-details {
    grid-template-columns: 1fr;
  }

  .governance-grid {
    grid-template-columns: 1fr;
  }

  .report-item {
    flex-direction: column;
    text-align: center;
  }
}
</style>
