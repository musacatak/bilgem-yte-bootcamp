# Ortam Kurulumu

Idea üzerinden Get From VCS ile repository klonlanır:

![repository clone.png](img/repository%20clone.png)

Repository klonlandıktan sonra terminalden (docker-compose.yml dosyasının olduğu dizinde) Örnek veritabanı aşağıdaki komut ile oluşturulur:

```sh
docker-compose up -d
```

Docker desktop üzerinden örnek veritabanının oluşturulduğu kontrol edilir.

![Örnek veritabanı oluşturma](img/docker-connect-db.png)

Bağlantı bilgileri:

```bash
kullanıcı: postgres
parola: postgres
port: 5442
```