# QA Web Case - Insider Test Automation Project

Bu proje, Insider şirketinin web sitesi için Selenium WebDriver kullanılarak geliştirilmiş end-to-end test otomasyon projesidir.

## 📋 Proje Hakkında

Bu test projesi, Insider'ın kariyer sayfalarını test etmek için tasarlanmıştır. Test senaryoları şunları kapsar:
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

## 🧪 Test Senaryoları

### 1. Ana Sayfa Testi (`homePageTest`)
- Insider ana sayfasının yüklenmesini doğrular
- Ana sayfa ikonunun görünürlüğünü kontrol eder
- Sayfa başlığının doğruluğunu kontrol eder
- Şirket menüsüne tıklar ve Kariyer sayfasına yönlendirir

### 2. Kariyer Sayfası Testi (`careerPageTest`)
- Kariyer sayfası URL'sini doğrular
- "Our Story" bölümünü kontrol eder
- "Find your calling" takım bölümünü doğrular
- "Our Locations" bölümünü ve 25 lokasyon olduğunu kontrol eder
- "Life at Insider" bölümünü doğrular

### 3. Kalite Güvencesi Sayfası Testi (`qualityAssurancePageTest`)
- Kalite Güvencesi sayfası URL'sini doğrular
- Sayfa başlığını kontrol eder
- "See all QA jobs" butonuna tıklar

### 4. Açık Pozisyonlar Sayfası Testi (`openPositionPageTest`)
- Açık pozisyonlar sayfası URL'sini doğrular

## 🔧 Özellikler

- **Page Object Model**: Kod tekrarını azaltır ve bakımı kolaylaştırır
- **Çoklu Tarayıcı Desteği**: Chrome, Firefox ve Edge
- **Headless Mod**: CI/CD ortamları için uygun
- **Otomatik Bekleme**: WebDriverWait ile güvenilir testler
- **Assertion Kütüphanesi**: AssertJ ile güçlü doğrulamalar
- **Test Loglama**: TestLogger ile detaylı loglar
- **Cookie Yönetimi**: Otomatik cookie kabul etme

## 📊 Test Raporları

Test sonuçları `target/surefire-reports/` dizininde oluşturulur.

## 🐛 Sorun Giderme

### Yaygın Sorunlar:

1. **Tarayıcı sürücü sorunları**: En güncel WebDriver sürücülerini kullandığınızdan emin olun
2. **Timeout sorunları**: `BasePage.java` dosyasındaki wait sürelerini artırabilirsiniz
3. **Element bulunamadı**: Sayfa yapısı değişmiş olabilir, locator'ları güncelleyin

### Debug Modu:
```bash
mvn test -DholdOnExitSec=60
```

## 🤝 Katkıda Bulunma

1. Fork yapın
2. Feature branch oluşturun (`git checkout -b feature/AmazingFeature`)
3. Değişikliklerinizi commit edin (`git commit -m 'Add some AmazingFeature'`)
4. Branch'inizi push edin (`git push origin feature/AmazingFeature`)
5. Pull Request oluşturun

## 📝 Lisans

Bu proje MIT lisansı altında lisanslanmıştır.

## 👨‍💻 Geliştirici

**Kerem Metin**
- GitHub: [@E2Kerem01](https://github.com/E2Kerem01)

## 📞 İletişim

Herhangi bir sorunuz veya öneriniz için issue açabilir veya iletişime geçebilirsiniz.

---

**Not**: Bu proje eğitim amaçlı geliştirilmiştir ve Insider şirketinin resmi test projesi değildir.
