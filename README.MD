# Nearby Search Application

Bu uygulama, belirli bir konuma yakın yerleri bulmak için Google Places API'yi kullanan bir örnek uygulamadır.

## Özellikler

- **Yakındaki Yerleri Arama**: Belirtilen bir konuma (latitude ve longitude) ve yarıçapa göre yakındaki yerleri arar.
- **REST API Entegrasyonu**: Google Places API ile entegrasyon yapılarak yer arama işlemleri gerçekleştirilir.
- **Hata Yönetimi**: HTTP isteklerinde oluşabilecek hataları işleyen özel bir hata yöneticisi (error handler) bulunur.
- **Veritabanı Entegrasyonu**: Bulunan yerler, veritabanına kaydedilir ve aynı arama tekrar yapıldığında veritabanından döner.

## Kullanılan Teknolojiler

- Java
- Spring Boot
- Java Persistence API (JPA)
- Lombok
- RestTemplate
- PostgreSQL (veritabanı)

## Kurulum

1. **Projeyi İndirme**


2. **Veritabanı Yapılandırması**

- PostgreSQL veritabanı oluşturun ve bağlantı ayarlarını `application.properties` dosyasında güncelleyin.

3. **Google API Anahtarı Ayarı**

- Google Places API kullanabilmek için bir API anahtarı alın ve `application.properties` dosyasında `google.api.key` olarak belirtin.

4. **Uygulamayı Başlatma**


5. **Uygulama Kullanımı**

- Tarayıcı veya API test araçları ile `http://localhost:8080/places?latitude=...&longitude=...&radius=...` adresine istek yaparak yakındaki yerleri arayabilirsiniz.

## Katkıda Bulunma

- Kodunuzu geliştirmek veya hataları düzeltmek için pull request gönderebilirsiniz.
- Yeni özellikler önermek veya hataları bildirmek için GitHub issues üzerinden geri bildirimde bulunabilirsiniz.

