package app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class GreetingController {


    @RequestMapping("/books")
    public List<BookOld> listAllBooks(
            @RequestParam(value="adres", defaultValue="") String adres,
            @RequestParam(value="sztuk", defaultValue="1") Integer sztuk
            ) {
        BookOld g = new BookOld("W. Gombrowicz", "Ferdydurke", 101 * sztuk, adres);

        List<BookOld> res = new ArrayList<>();
        res.add(g);
        res.add(g);
        res.add(g);
        return res;
    }


}
