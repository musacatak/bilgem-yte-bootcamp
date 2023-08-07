package yte.intern.springweb.user;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vatandas")
public class UserController {
    @PostMapping("/create")
    public ResponseEntity<String> createUser(@Validated @RequestBody User user) {

        System.out.println(user);
        // Kullanıcıyı kaydetme işlemi burada gerçekleştirilebilir
        return ResponseEntity.ok("Kullanıcı başarıyla oluşturuldu");
    }
}
