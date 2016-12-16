package app;

import app.model.Book;
import app.service.BookDAO;
import app.service.BookDAOJdbc;
import lombok.extern.slf4j.Slf4j;
import sun.nio.ch.ThreadPool;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Pisane na podstawie:
 * https://www.tutorialspoint.com/spring/spring_jdbc_example.htm
 */

@Slf4j
public class Benchmark {
    public static void main(String[] args) throws Exception {
        BookDAO dao = new BookDAOJdbc();
        int REQUESTS = 200000;
        ExecutorService service = Executors.newFixedThreadPool(2);
        Long st = System.currentTimeMillis();
        AtomicLong full = new AtomicLong(0);
        for (Integer i = 0; i < REQUESTS; i++) {
            Integer w = i;
            service.execute(() -> {
                String autor = UUID.randomUUID().toString();
                String title = UUID.randomUUID().toString();
                dao.insertNew(new Book(0,autor,title));
                if (w%1000==0) {
                    System.out.println(w);
//                    full.addAndGet(dao.findAll().size());
                }
            });
            Thread.sleep(2);
        }
        service.execute(() -> {
            long en = System.currentTimeMillis();
            System.out.println("Requests/sec = " + (REQUESTS * 1000 / (en - st)) + " full=" + full.get());
        });

        service.shutdown();

    }
}
