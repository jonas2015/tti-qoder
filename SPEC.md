# TTi Group Corporate Website Specification

## 1. Project Overview

- **Project Name**: TTi Group Corporate Website Clone
- **Project Type**: Full-stack web application (Vue.js + Spring Boot)
- **Core Functionality**: A professional corporate website showcasing company information, brand portfolio, investor relations, governance, sustainability, careers, and news sections
- **Target Users**: Investors, stakeholders, job seekers, business partners, and general public

## 2. UI/UX Specification

### Layout Structure

#### Page Sections
- **Header**: Sticky navigation bar with logo, main navigation menu, language selector
- **Hero Section**: Large banner with company tagline and call-to-action
- **About Section**: Company introduction with key statistics
- **Brands Section**: Grid showcase of brand logos
- **Investors Section**: Financial highlights and document downloads
- **Sustainability Section**: ESG initiatives and achievements
- **Careers Section**: Job openings and company culture
- **News Section**: Latest company news and announcements
- **Footer**: Multi-column layout with quick links, contact info, social media

#### Grid/Flex Layout
- CSS Grid for brand showcases (4 columns desktop, 2 tablet, 1 mobile)
- Flexbox for navigation and card layouts
- Maximum content width: 1400px centered

#### Responsive Breakpoints
- Mobile: < 768px
- Tablet: 768px - 1024px
- Desktop: > 1024px

### Visual Design

#### Color Palette
- **Primary**: #1A1A1A (Dark Charcoal - headers, main text)
- **Secondary**: #FFFFFF (White - backgrounds)
- **Accent**: #E63946 (Corporate Red - CTAs, highlights)
- **Muted**: #6C757D (Gray - secondary text)
- **Light Gray**: #F8F9FA (Section backgrounds)
- **Border**: #DEE2E6 (Dividers, borders)

#### Typography
- **Primary Font**: "Inter", "Segoe UI", sans-serif
- **Headings**: 
  - H1: 48px, weight 700
  - H2: 36px, weight 600
  - H3: 24px, weight 600
  - H4: 18px, weight 600
- **Body**: 16px, weight 400, line-height 1.6
- **Small**: 14px, weight 400

#### Spacing System
- Base unit: 8px
- Section padding: 80px vertical
- Card padding: 24px
- Component gap: 16px

#### Visual Effects
- Box shadows: 0 2px 8px rgba(0,0,0,0.08) for cards
- Hover transitions: 0.3s ease for all interactive elements
- Subtle hover lift effect on cards (transform: translateY(-4px))

### Components

#### Navigation
- Logo on left
- Main menu items with dropdown support
- Language selector on right
- Mobile hamburger menu

#### Hero Banner
- Full-width image/gradient background
- Overlay text with headline and subtext
- CTA button

#### Brand Cards
- Logo image centered
- Brand name below
- Hover effect with slight scale

#### News Cards
- Featured image
- Date and category
- Title and excerpt
- "Read More" link

#### Statistics Counter
- Large number display
- Label text
- Icon support

#### Footer Links
- Column-based grouping
- Link lists
- Contact information
- Social media icons

## 3. Functionality Specification

### Core Features

#### Frontend (Vue.js)
1. **Routing**: Vue Router for page navigation
2. **State Management**: Pinia for global state
3. **HTTP Client**: Axios for API calls
4. **Components**: Reusable Vue components

#### Pages
1. **Home** - Overview with all sections
2. **About** - Company history, leadership, statistics
3. **Brands** - Brand portfolio grid
4. **Investors** - Financial data, reports
5. **Sustainability** - ESG initiatives
6. **Careers** - Job listings
7. **News** - News articles list
8. **Contact** - Contact form

#### Backend (Spring Boot)
1. **REST APIs**:
   - GET /api/brands - List all brands
   - GET /api/news - List news articles
   - GET /api/news/{id} - Single news article
   - GET /api/careers - List job openings
   - GET /api/about - Company information
   - GET /api/statistics - Company statistics
   - POST /api/contact - Contact form submission

2. **Data Models**:
   - Brand (id, name, logo, description)
   - NewsArticle (id, title, content, date, category, imageUrl)
   - JobOpening (id, title, department, location, description)
   - CompanyInfo (name, description, history, leadership)
   - Statistics (employees, countries, brands, years)
   - ContactMessage (name, email, subject, message, date)

## 4. Acceptance Criteria

### Visual Checkpoints
- [ ] Header is sticky and contains logo, navigation, language selector
- [ ] Hero section displays with proper background and text
- [ ] Brand cards display in responsive grid
- [ ] News articles show with images and dates
- [ ] Footer has multi-column layout with all links
- [ ] All hover effects work smoothly
- [ ] Site is responsive across all breakpoints

### Functionality Checkpoints
- [ ] All navigation links work correctly
- [ ] API endpoints return proper data
- [ ] Contact form submits successfully
- [ ] No console errors on page load
- [ ] Smooth page transitions

### Technical Requirements
- [ ] Vue.js 3 with Composition API
- [ ] Spring Boot 3.x with Java 17+
- [ ] RESTful API design
- [ ] Clean code structure
- [ ] Proper error handling
