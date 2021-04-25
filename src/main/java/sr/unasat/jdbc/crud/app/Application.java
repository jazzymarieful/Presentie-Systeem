package sr.unasat.jdbc.crud.app;

import sr.unasat.jdbc.crud.entities.Lokaal;
import sr.unasat.jdbc.crud.entities.Presentie;
import sr.unasat.jdbc.crud.entities.Studenten;
import sr.unasat.jdbc.crud.repositories.PresentieRepository;
import sr.unasat.jdbc.crud.repositories.StudentenRepository;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        StudentenRepository studRepo = new StudentenRepository();
        PresentieRepository presRepo = new PresentieRepository();

//        //opdracht: Insert nieuwe records in een willekeurige tabel.
//        Studenten student2 = new Studenten(105, "Maarten", "Narain", "m.narain@unasat.sr");
//        studRepo.insertOneRecord(student2);
//
//        //opdracht: update van beide foreign keys in tabel met 2 foreign keys
//        Studenten studentUpdate = new Studenten(100);
//        Lokaal lokaalUpdate = new Lokaal(1);
//        Presentie presentieUpdate = new Presentie(1, "2025-06-25", studentUpdate, lokaalUpdate);
//        presRepo.updateOneRecord(presentieUpdate);
//
//        //opdracht: select op de tabel T3 met 2 foreignkeys (joins)
//        List<Presentie> presentielijst = presRepo.findAllRecords();
//        for (Presentie presentie : presentielijst) {
//            System.out.println(presentie);
//        }
//
//        opdracht: delete van records in tabel T3
//        Presentie presentie = new Presentie(3);
//        presRepo.deleteOneRecord(presentie);
//
//        opdracht: insert nieuwe records in een tabel T3
//        Studenten studentnew = new Studenten(200);
//        Lokaal lokaalnew = new Lokaal(3);
//        Presentie presentienew = new Presentie(5, "2020-06-11 16:00:00", studentnew, lokaalnew);
//        presRepo.insertOneRecord(presentienew);

    }
}
