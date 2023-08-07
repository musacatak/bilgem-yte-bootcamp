package yte.intern.springweb.user;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

record User(
        @NotBlank(message = "Ad boş olamaz") String isim,
        @NotBlank(message = "Soyad boş olamaz") String soyisim,
        @Min(12) @Max(100) Long yas,
        @NotBlank(message = "Email boş olamaz") @Email(message = "Geçerli bir e-mail adresi giriniz") String emailAdresi,
        @TcKimlikNo String tcKimlikNo,
        @PastOrPresent(message = "Doğum tarihi bugün veya daha önce olmalı") LocalDate dogumTarihi,
        @Size(max = 250, message = "İkametgah adresi 250 karakterden kısa olmalı") String ikametgahAdresi,
        @NotBlank(message = "Kullanıcı adı boş olamaz")  @ValidUsername String kullaniciAdi
){}

//public class User {
//    @NotBlank(message = "Ad boş olamaz")
//    private String isim;
//    @NotBlank(message = "Soyad boş olamaz")
//    private String soyisim;
//    @Size(min=12, max = 100)
//    private Long yas;
//    @NotBlank(message = "Email boş olamaz")
//    @Email(message = "Geçerli bir e-mail adresi giriniz")
//    private String emailAdresi;
//    @Pattern(regexp = "^[1-9]{1}[0-9]{9}[02468]{1}$", message = "Geçerli bir TC kimlik numarası giriniz")
//    private Long tcKimlikNo;
//    @PastOrPresent(message = "Doğum tarihi bugün veya daha önce olmalı")
//    private Date dogumTarihi;
//    @Size(max = 250, message = "İkametgah adresi 250 karakterden kısa olmalı")
//    private String ikametgahAdresi;
//    @NotBlank(message = "Kullanıcı adı boş olamaz")
//    @Pattern(regexp = "^(?!admin$)[a-zA-Z0-9._-]{3,}$", message = "Geçerli bir kullanıcı adı giriniz")
//    private String kullanıcıAdı;
//
//
//}
