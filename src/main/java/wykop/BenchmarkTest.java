package wykop;

import java.util.*;

/**
 * Created on 12/10/16 : 10:18 PM.
 */
public class BenchmarkTest {
    public static void main(String[] args) {
        int NGROUPS = 10_000; //that many groups
        int NENTS = 1000_000;  //that many ents
        int NENTS_PER_GROUP = 1000;
        int NGROUPS_PER_USER = 200;
        //performance of "all ents of u";
        //u --> 1000 G's
        //gater all ents of these 1000G's
        Random r = new Random(111);

        Map<Integer, Set<Integer>> grp_ents = new HashMap<>();
        for (int i = 0; i < NGROUPS; i++) {
            Set<Integer> ents = new HashSet<>();
            for (int j = 0; j < NENTS_PER_GROUP; j++) {
                ents.add(r.nextInt(NENTS));
            }
            grp_ents.put(i, ents);
        }
        Set<Integer> groupsOfUser = new HashSet<>();
        for (int i = 0; i < NGROUPS_PER_USER; i++) {
            groupsOfUser.add(r.nextInt(NGROUPS));
        }
        //////////////
        System.out.println("starting");
        for (int i = 0; i < 10; i++) {
//            Set<Integer> result = new HashSet<>(0);
            BitSet res = new BitSet(NENTS);
            long st = System.currentTimeMillis();
            //
            for(int g : groupsOfUser) {
                for(int e : grp_ents.get(g)) {
//                    result.add(e);
                    res.set(e);
                }
            }
//            System.out.println(result.size());
            System.out.println(res.cardinality());
            long dur = System.currentTimeMillis() - st;
            System.out.println(dur + "[ms]");
        }

    }
}
