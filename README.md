# Kütüphane Yönetim Sistemi

Bu proje,  **Spring Boot** ve **Spring Security** kullanılarak geliştirilmiş bir kütüphane yönetim sistemi uygulamasıdır. Kullanıcıların kitap, yazar ve yayınevi bilgilerini yönetmesine olanak tanıyan bu uygulama, güvenli bir şekilde kimlik doğrulama ve yetkilendirme sağlamaktadır. Aynı zamanda hem standart kullanıcıların hem de yönetici yetkisine sahip kullanıcıların farklı yetkilerle sistemi kullanmasına olanak tanır.
## Kullanılan Teknolojiler

- **Spring Boot 3.1.2**: Uygulamanın temel çatısı.
- **Spring Security**: Kimlik doğrulama ve yetkilendirme.
- **Spring Data JPA**: Veritabanı işlemleri için JPA kullanımı.
- **Thymeleaf**: Sunucu tarafı sayfa oluşturma motoru.
- **MySQL**: Veritabanı yönetim sistemi.
- **Maven**: Proje yönetimi ve bağımlılık yönetimi.
## Özellikler
- **Yazar Tanımı**: Yazar adı ve açıklaması girilebilir.
- **Yayın Evi Tanımı**: Yayın evi adı ve açıklaması girilebilir.
- **Kitap Tanıtımı**: Kitap adı, alt başlık, seri adı, yazar, yayın evi, ISBN numarası ve açıklama tanımlanabilir.
- **Kitap Arama**: Kitap adı, seri adı, yazar adı ya da ISBN numarası ile kitap araması yapılabilir.
- **Kayıt Güncelleme ve Silme**: Mevcut kayıtlar incelenebilir, güncellenebilir ve silinebilir.
- **Yetkilendirme Sistemi**: 
    - **Standart Kullanıcı**: Kayıt oluşturabilir, yazar, kitap ve yayın evlerini ilişkilendirebilir ancak mevcut kayıtları silemez.
    - **Yönetici (Admin)**: Tüm eylemleri gerçekleştirebilir (silme dahil).
- **Kod Standartlarına Uygunluk**: Yazılım, temiz kod ve kod standartlarına uygun olarak geliştirilmiştir.
- **IDE Gereksinimi Yok**: Proje, herhangi bir IDE gerektirmeden çalıştırılabilir.
- **Özgür ve Açık Kaynak Yazılım Kullanımı**: Projede, özgür ve açık kaynak kodlu olmayan yazılımlar kullanılmamıştır.

## Kurulum

Projeyi çalıştırmak için aşağıdaki adımları izleyin:

1. Depoyu klonlayın:
    ```bash
    git clone <repository_url>
    ```
2. Gerekli bağımlılıkları yükleyin:
    ```bash
    mvn install
    ```
    
3.  ⁠Veritabanı bağlantı yapılandırmasını yapın (application.properties):
    ```bash
       spring.datasource.url=jdbc:mysql://localhost:3306/veritanbanı-adı
       spring.datasource.username=root
       spring.datasource.password=password
    ```
   
4. Uygulamayı başlatın:
    ```bash
    mvn spring-boot:run
    ```

5. Uygulama varsayılan olarak http://localhost:8080/user/login adresinde çalışacaktır

## API Endpoints

### Kullanıcı Girişi
- **GET, POST** `/user/login`  
  Kullanıcı adı ve parola ile sisteme giriş yapar. Varsayılan olarak oluşturulan kullanıcılar standart kullanıcıdır.
  
- **POST** `/user/logout`  
  Kullanıcı sistemden çıkış yapar.

- **POST** `/user/register`  
  Sisteme yeni kullanıcı kaydı yapar.

- **GET** `/user/registerPage`  
  Kayıt sayfasını görüntüler.

- **GET** `/user/current-user`  
  Geçerli kullanıcının bilgilerini döner.

### Yazar İşlemleri

- **GET** `/authors/addauthor`  
  Yeni bir yazar ekleme sayfasını getirir.

- **GET** `/authors/getauthors`  
  Tüm yazarları listeleyen endpoint.

- **POST** `/authors/saveAuthor`  
  Yeni bir yazar eklemek için kullanılır.

- **GET** `/authors/update/{id}`  
  Var olan bir yazarı güncelleme sayfasını getirir.

- **POST** `/authors/updateAuthor`  
  Var olan bir yazar bilgisini günceller.

### Kitap İşlemleri

- **GET, POST** `/home/addbook`  
  Yeni bir kitap ekleme sayfasını getirir ve yeni kitap ekler.

- **GET** `/home/allbook`  
  Tüm kitapları listeleyen endpoint.

- **POST** `/home/delete/{id}`  
  Belirli bir kitabı sistemden siler.

- **GET** `/home/getbook/{id}`  
  Belirli bir kitabı id'si ile getirir.

- **POST** `/home/savebook`  
  Yeni bir kitap eklemek için kullanılır.

- **GET, POST** `/home/search`  
  Kitap arama işlemi yapar.

- **GET** `/home/update/{id}`  
  Kitap güncelleme sayfasını getirir.

- **POST** `/home/updateBook`  
  Var olan bir kitabı günceller.

### Yayın Evi (Houses) İşlemleri

- **GET** `/houses/addhouse`  
  Yeni bir yayınevi ekleme sayfasını getirir.

- **GET** `/houses/gethouse`  
  Tüm yayınevlerini listeleyen endpoint.

- **POST** `/houses/savehouse`  
  Yeni bir yayınevi eklemek için kullanılır.

- **GET** `/houses/update/{id}`  
  Yayınevi güncelleme sayfasını getirir.

- **POST** `/houses/updateHouse`  
  Var olan bir yayınevini günceller.

## Yetkilendirme ve Güvenlik

Uygulama, kullanıcıların sisteme giriş yapabilmesi ve belirli yetkilere sahip olabilmesi için bir yetkilendirme mekanizması sunar. Yetkilendirme işlemleri, Spring Security kullanılarak sağlanmıştır.

- **Standart Kullanıcı**: Kitap, yazar ve yayınevi kaydı oluşturabilir ve ilişkilendirebilir, ancak mevcut kayıtları silemez.
- **Yönetici Kullanıcı**: Tüm kayıtları oluşturabilir, güncelleyebilir ve silebilir.

**Admin Kullanıcı**:

- **Kullanıcı Adı**: `husnabykl@com`
- **Şifre**: `123`

> **Not**: Admin kullanıcıya erişebilmek için veritabanının import edilmesi gerekmektedir. (/SQL.sql)

## Güvenlik Konfigürasyonu
Güvenlik ayarları, `SecurityConfig.java` dosyasında yapılmıştır. Yetkilendirme işlemleri ve API uç noktalarına erişim denetimleri burada tanımlanmıştır.

## Veritabanı Yapılandırması

Uygulama, varsayılan olarak **MySQL** veritabanı ile çalışmaktadır. 

