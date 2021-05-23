package com.example.kuyumcutakipsistemi;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.strictmode.SqliteObjectLeakedViolation;
import androidx.annotation.Nullable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class veri_tabani_baglanti extends SQLiteOpenHelper {

    public static final String DB_NAME="Kuyumculuk_db.db";
    public veri_tabani_baglanti(Context context) {
        super(context,"Kuyumculuk_db.db", null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Boolean checkusername(String Kullanici_ad){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select *from Kullanicilar where Kullanici_ad=?",new
                String[] {Kullanici_ad});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkusernamepassword(String Kullanici_ad,String Parola){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select * from Kullanicilar where Kullanici_ad=? and Parola=?",new String[] {Kullanici_ad,Parola});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean insertMüsteri(String ad,String soyad,String tc_no,String tel_no){
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("ad",ad);
        contentValues.put("soyad",soyad);
        contentValues.put("TC_NO",tc_no);
        contentValues.put("Telefon",tel_no);
        long result=db.insert("Musteri_hesaplari_tum_musteriler",null,contentValues);
        if(result==-1)
            return false;
        else
            return true;

    }

    public Cursor getdata(String tc_no){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from Musteri_hesaplari_tum_musteriler where TC_NO=? ",new String[]{tc_no},null);
        return cursor;
    }

    public Boolean insertAltin(String ad,String hasmilyem,String grm_malyt_milyem,String adet_mlyt_mlym,String alis_mylm,String sts_mlym,String adet_iscilik,String grm_stok,String adet_stok){
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("Urun_ad",ad);
        contentValues.put("Has_milyem",hasmilyem);
        contentValues.put("Gr_Mlyt_Milyem",grm_malyt_milyem);
        contentValues.put("Adt_Mlyt_Milyem",adet_mlyt_mlym);
        contentValues.put("Alis_Milyem",alis_mylm);
        contentValues.put("Satis_Milyem",sts_mlym);
        contentValues.put("Adetli_isçilik",adet_iscilik);
        contentValues.put("Gram_stok",grm_stok);
        contentValues.put("Adet_stok",adet_stok);

        long result=db.insert("Urun_listesi_Altin",null,contentValues);
        if(result==-1)
            return false;
        else
            return true;

    }

    public Cursor getdata_altin(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from Urun_listesi_Altin ",null);
        return cursor;
    }

    public Boolean insertDoviz(String urun,String para_birimi,String maliyet_fiyati,String alis_fiyati,String satis_fiyati,String stok){
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("urun",urun);
        contentValues.put("para_birimi",para_birimi);
        contentValues.put("maliyet_fiyati",maliyet_fiyati);
        contentValues.put("alis_fiyati",alis_fiyati);
        contentValues.put("satis_fiyati",satis_fiyati);
        contentValues.put("stok",stok);

        long result=db.insert("Urun_listesi_doviz",null,contentValues);
        if(result==-1)
            return false;
        else
            return true;

    }

    public Cursor getdata_doviz(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from Urun_listesi_doviz ",null);
        return cursor;
    }

    public Boolean insertZiynet(String Urun,String has_milyem,String maliyet_milyem,String alis_milyem,String satis_milyem,String has_agırlık,String urun_agirlik,String adet_stok){
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("urun",Urun);
        contentValues.put("has_milyem",has_milyem);
        contentValues.put("maliyet_milyem",maliyet_milyem);
        contentValues.put("alis_milyem",alis_milyem);
        contentValues.put("satis_milyem",satis_milyem);
        contentValues.put("has_agırlık",has_agırlık);
        contentValues.put("urun_agirlik",urun_agirlik);
        contentValues.put("adet_stok",adet_stok);

        long result=db.insert("Urun_listesi_ziynet",null,contentValues);
        if(result==-1)
            return false;
        else
            return true;

    }

    public Cursor getdata_ziynet(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from Urun_listesi_ziynet ",null);
        return cursor;
    }

    public Boolean insertKategori(String id,String kategori_tipi,String urun_listesi){
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("id",id);
        contentValues.put("Kategori_tipi",kategori_tipi);
        contentValues.put("Urun_listesi",urun_listesi);


        long result=db.insert("Kategori_Listesi",null,contentValues);
        if(result==-1)
            return false;
        else
            return true;

    }

    public Cursor getdata_kategori(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from Kategori_Listesi ",null);
        return cursor;
    }

    public Boolean insertMarka(String id,String marka_adi,String marka_tipi,String aciklama){
        SQLiteDatabase db=this.getReadableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("id",id);
        contentValues.put("Marka_adi",marka_adi);
        contentValues.put("Marka_tipi",marka_tipi);
        contentValues.put("Aciklama",aciklama);


        long result=db.insert("Marka_listesi",null,contentValues);
        if(result==-1)
            return false;
        else
            return true;

    }

    public Cursor getdata_marka(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from Marka_listesi ",null);
        return cursor;
    }


}
