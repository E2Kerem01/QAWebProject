# QA Web Case - Test Automation Project

Bu proje, web sitesi için Selenium WebDriver kullanılarak geliştirilmiş end-to-end test otomasyon projesidir.

## 📋 Proje Hakkında

Bu test projesi, senaryoları şunları kapsar:
- Ana sayfa doğrulaması
- Kariyer sayfası kontrolleri
- Kalite Güvencesi sayfası testleri
- Açık pozisyonlar sayfası kontrolleri

## 🛠️ Teknolojiler

- **Java 17**
- **Selenium WebDriver 4.35.0**
- **TestNG 7.10.2**
- **AssertJ 3.26.0**
- **Maven** (Proje yönetimi)
- **Chrome, Firefox, Edge** (Desteklenen tarayıcılar)

## 📁 Proje Yapısı

```
src/
├── main/java/
│   ├── com/insider/pages/          # Page Object Model sınıfları
│   │   ├── HomePage.java
│   │   ├── CareersPage.java
│   │   ├── QualityAssurancePage.java
│   │   └── OpenPositionsPage.java
│   └── utils/
│       └── BasePage.java           # Temel sayfa işlevleri
└── test/java/
    ├── com/qa/
    │   ├── BaseTest.java           # Test temel sınıfı
    │   ├── InsiderCaseTest.java    # Ana test sınıfı
    │   └── listeners/
    │       └── TestLogger.java     # Test loglama
    └── resources/
```

## 🚀 Kurulum ve Çalıştırma

### Gereksinimler
- Java 17 veya üzeri
- Maven 3.6 veya üzeri
- Chrome, Firefox veya Edge tarayıcısı

### Kurulum
1. Projeyi klonlayın:
```bash
git clone <repository-url>
cd qa-web-case
```

2. Maven bağımlılıklarını yükleyin:
```bash
mvn clean install
```

### Test Çalıştırma

#### Tüm testleri çalıştırma:
```bash
mvn test
```

#### Belirli tarayıcı ile çalıştırma:
```bash
# Chrome (varsayılan)
mvn test -Dbrowser=chrome

# Firefox
mvn test -Dbrowser=firefox

# Edge
mvn test -Dbrowser=edge
```

#### Headless modda çalıştırma:
```bash
mvn test -Dheadless=true
```

#### Test sonrası tarayıcıyı açık tutma:
```bash
mvn test -DholdOnExitSec=30
```


## 📊 Test Raporları

Test sonuçları `target/surefire-reports/` dizininde oluşturulur.
