package hallo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@RestController
public class GreetingController {


    @RequestMapping("/books")
    public List<Book> listAllBooks(
            @RequestParam(value="adres", defaultValue="") String adres,
            @RequestParam(value="sztuk", defaultValue="1") Integer sztuk
            ) {
        Book g = new Book("W. Gombrowicz", "Ferdydurke", 101 * sztuk, adres);

        List<Book> res = new ArrayList<>();
        res.add(g);
        res.add(g);
        res.add(g);
        return res;
    }


}
