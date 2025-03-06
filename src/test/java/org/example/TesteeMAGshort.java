package org.example;

import org.junit.Test;


public class TesteeMAGshort {
    //private static final Logger log = LoggerFactory.getLogger(emag.class);
   // WebDriver driver;
    @Test
public void setup () throws Exception{


ContulmeuLogin test1 = new ContulmeuLogin();
         test1.setup();
         test1.souldbeanswerWithTrue();
         test1.teardown();

Baradecautare test2 = new Baradecautare();
         test2.setup();
         test2.souldbeanswerWithTrue();
         test2.teardown();

AdaugainCos test3= new AdaugainCos();
         test3.setup();
         test3.souldbeanswerWithTrue();
         test3.teardown();

AdaugalaFavorite test4 = new AdaugalaFavorite();
         test4.setup();
         test4.souldbeanswerWithTrue();
         test4.teardown();


OfertaZilei test5 = new OfertaZilei();
         test5.setup();
         test5.souldbeanswerWithTrue();
         test5.teardown();

Resigilate test6 = new Resigilate();
        test6.setup();
        test6.souldbeanswerWithTrue();
        test6.teardown();

Logo test7 = new Logo();
        test7.setup();
        test7.souldbeanswerWithTrue();
        test7.teardown();


ButonPLus test8 = new ButonPLus();
        test8.setup();
        test8.souldbeanswerWithTrue();
        test8.teardown();


Sterge test9 = new Sterge();
        test9.setup();
        test9.souldbeanswerWithTrue();
        test9.teardown();

    }
}
