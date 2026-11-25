# Spring Boot ile Hibernate Validator ve jQuery Validation

Aynı doğrulama kurallarını sunucu tarafında Hibernate Validator (Bean Validation) anotasyonlarıyla, tarayıcı
tarafında jQuery Validation sınıf kurallarıyla tanımlamayı gösteren küçük bir Spring Boot örneği.

> **Not:** Bu depo 2018 yılında eğitim/örnek amaçlı yazıldı ve artık güncellenmiyor. Bağımlılıkları eskidir ve
> bilinen güvenlik açıkları içerir; üretimde kullanmayın.

## İçerik

`hibernatevalidation/` klasöründeki Spring Boot projesi:

- `entity/User.java`: `@NotNull`, `@Size`, `@Pattern` kurallarıyla `User` entity'si (Lombok `@Data`). Silme işlemi
  `@SQLDelete` ve `@Where` ile kaydı silmek yerine `deleted` alanını işaretleyen "soft delete" olarak tanımlanmıştır.
- `controller/UserController.java`: `/user/` adresine gelen formu `@Valid` ile doğrulayan denetleyici.
- `templates/index.html`: `valRequired`, `valSize4-50`, `valMail`, `valAlphanumericRegex` gibi CSS sınıflarına
  bağlanan jQuery Validation kuralları ve şifre tekrar alanı için `equalTo` kontrolü.

Örnek bir taslak olarak kalmıştır: denetleyicinin döndürdüğü görünümler (`user`, `sucess`, `from`) projede yoktur
ve `@SQLDelete` içindeki sorgu PostgreSQL sözdizimi kullanırken bağımlılık olarak MySQL sürücüsü eklenmiştir.

## Teknolojiler

- Java 8, Maven (Maven Wrapper 3.5.2)
- Spring Boot 1.5.9 (Web, Data JPA, Thymeleaf), Hibernate Validator, Lombok
- MySQL JDBC sürücüsü
- jQuery 3.2.1 ve jQuery Validation 1.17.0 (CDN üzerinden)

## Çalıştırma

1. İstemci tarafı doğrulamayı görmek için `hibernatevalidation/src/main/resources/templates/index.html`
   dosyasını doğrudan tarayıcıda açmanız yeterli.
2. Uygulamayı başlatmak için `application.properties` boştur; Spring Boot'un açılabilmesi için
   `spring.datasource.url`, `spring.datasource.username` ve `spring.datasource.password` değerlerini kendi
   veritabanınıza göre eklemeniz gerekir.
3. Ardından:

```bash
cd hibernatevalidation
./mvnw spring-boot:run
```
