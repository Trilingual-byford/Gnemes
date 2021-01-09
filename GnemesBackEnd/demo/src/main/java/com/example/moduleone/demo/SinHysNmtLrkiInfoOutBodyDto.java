package com.example.moduleone.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SinHysNmtLrkiInfoOutBodyDto {
    /** 伝票番号 */ private String dnpNo;

    /** 荷物ID */ private Long nmtId;

    /** サイズ品目コード */ private String sizHnmCd;

    /** 荷主名 */ private String nnsNm;

    /** 現荷物ステータスコード */ private String nowNmtStsCd;

    /** 現荷物ステータス詳細コード */ private String nowNmtStsShsCd;

    /** 受取人住所１ */ private String uknJys1;

    /** 受取人住所２ */ private String uknJys2;

    /** 受取人住所３ */ private String uknJys3;

    /** 受取人住所４ */ private String uknJys4;

    /** 受取人住所（１～４） */ private String uknJys1To4;

    /** 配送予定場所区分 */ private String hsoYtiBsyKbn;

    /** 配送予定営業所（事業所店所コード） */ private String hsoYtiEgsGgsTsyCd;

    /** 配送予定受取店（顧客コード） */ private String hsoYtiUttKkkCd;

    /** 配送予定受取店（原扱店店所コード） */ private String hsoYtiUttGatTsyCd;

    /** 配送予定日 */ private String hsoYtiDay;

    /** 最終更新日時 */ private String sasKsnTim;

    /** 最終更新ステータスコード */ private String sasKsnStsCd;

    /** 最終更新ステータス詳細コード */ private String sasKsnStsShsCd;

    /** ステータス履歴 */ private List stsRrk;

    /** 送り主名 */ private String oknNm;

    /** 受取人電話番号 */ private String uknTel;

    /** 荷物総件数 */ private int nmtSu;

    /** 配送指定日 */ private String hsoSteDay;

    /** 最終ステータス更新日 */ private String statusUpdYmd;

    /** 伝票種別 */ private String dnpSbt;

    /** HTTPステータスコード */ private String httpStsCd;

    /** 店所コード */ private String tsyCd;

    /** 配達先 */ private String httSki;

    /** 受取人名 */ private String uknNm;

    /** 品名 */ private String syhNm;

    /** 配送指定置き場所１ */ private String hsoSteOkb1;

    /** 配送予定置き場所２ */ private String hsoYtiOkb2;

    /** 配送予定置き場所３ */ private String hsoYtiOkb3;

    /** 配送指定時間帯（From） */ private String hsoSteJktFrm;

    /** 配送指定時間帯（To） */ private String hsoSteJktTo;

    /** 配送予定置き場所１ */ private String hsoYtiOkb1;

    /** 受取人郵便番号 */ private String uknYno;

    /** 宅配ボックス番号 */ private String thbNo;

    /** 宅配ボックスパスワード. */ private String thbPwd;

    /** 配完フラグ */ private String hikFlg;

    /** ステータス発生緯度 */ private String stsHsiIdo;

    /** ステータス発生経度 */ private String stsHsiKed;

    /** 更新日時 */ private String ksnTs;

    /** 着店店所コード */ private String cktTsyCd;

    /** 配送予定緯度 */ private double hsoYtiIdo;

    /** 配送予定経度 */ private double hsoYtiKed;
}


