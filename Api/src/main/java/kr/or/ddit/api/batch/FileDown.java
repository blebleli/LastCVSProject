package kr.or.ddit.api.batch;

public class FileDown {

   private  String kategorie1;   // 대분류
   private  String kategorie2;   // 중분류
   private  String name;      // 제품이름
   private  String uuidName;   // 파일이름
   private  String webImgPath;   // 인터넷경로
   private  String imgPath;   // 저장될위치
   private  String price;      // 가격
   private  String content;   // 제품설명
   private    String file_id;    // 자료 코드
   private    String ctgy_id1;    // 카테고리 코드 대 
   private    String ctgy_id2;    // 카테고리 코드 중
   private    String ctgy_id3;    // 카테고리 코드 소
   private  String ctgy_kind;  // 카테고리 구분코드
   
   private String bcd_id            ;   //   NOT NULL VARCHAR2(200)  
   private String bcd_content    ;//   NOT NULL CLOB           
   private String bcd_path       ;//   NOT NULL VARCHAR2(4000) 
   private String bcd_info        ;//VARCHAR2(4000) 
   private String bcd_kind       ;//   NOT NULL VARCHAR2(50)
   public String getKategorie1() {
      return kategorie1;
   }
   public void setKategorie1(String kategorie1) {
      this.kategorie1 = kategorie1;
   }
   public String getKategorie2() {
      return kategorie2;
   }
   public void setKategorie2(String kategorie2) {
      this.kategorie2 = kategorie2;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getUuidName() {
      return uuidName;
   }
   public void setUuidName(String uuidName) {
      this.uuidName = uuidName;
   }
   public String getWebImgPath() {
      return webImgPath;
   }
   public void setWebImgPath(String webImgPath) {
      this.webImgPath = webImgPath;
   }
   public String getImgPath() {
      return imgPath;
   }
   public void setImgPath(String imgPath) {
      this.imgPath = imgPath;
   }
   public String getPrice() {
      return price;
   }
   public void setPrice(String price) {
      this.price = price;
   }
   public String getContent() {
      return content;
   }
   public void setContent(String content) {
      this.content = content;
   }
   public String getFile_id() {
      return file_id;
   }
   public void setFile_id(String file_id) {
      this.file_id = file_id;
   }
   public String getCtgy_id1() {
      return ctgy_id1;
   }
   public void setCtgy_id1(String ctgy_id1) {
      this.ctgy_id1 = ctgy_id1;
   }
   public String getCtgy_id2() {
      return ctgy_id2;
   }
   public void setCtgy_id2(String ctgy_id2) {
      this.ctgy_id2 = ctgy_id2;
   }
   public String getCtgy_id3() {
      return ctgy_id3;
   }
   public void setCtgy_id3(String ctgy_id3) {
      this.ctgy_id3 = ctgy_id3;
   }
   public String getCtgy_kind() {
      return ctgy_kind;
   }
   public void setCtgy_kind(String ctgy_kind) {
      this.ctgy_kind = ctgy_kind;
   }
   public String getBcd_id() {
      return bcd_id;
   }
   public void setBcd_id(String bcd_id) {
      this.bcd_id = bcd_id;
   }
   public String getBcd_content() {
      return bcd_content;
   }
   public void setBcd_content(String bcd_content) {
      this.bcd_content = bcd_content;
   }
   public String getBcd_path() {
      return bcd_path;
   }
   public void setBcd_path(String bcd_path) {
      this.bcd_path = bcd_path;
   }
   public String getBcd_info() {
      return bcd_info;
   }
   public void setBcd_info(String bcd_info) {
      this.bcd_info = bcd_info;
   }
   public String getBcd_kind() {
      return bcd_kind;
   }
   public void setBcd_kind(String bcd_kind) {
      this.bcd_kind = bcd_kind;
   }
   @Override
   public String toString() {
      return "FileDown [kategorie1=" + kategorie1 + ", kategorie2="
            + kategorie2 + ", name=" + name + ", uuidName=" + uuidName
            + ", webImgPath=" + webImgPath + ", imgPath=" + imgPath
            + ", price=" + price + ", content=" + content + ", file_id="
            + file_id + ", ctgy_id1=" + ctgy_id1 + ", ctgy_id2=" + ctgy_id2
            + ", ctgy_id3=" + ctgy_id3 + ", ctgy_kind=" + ctgy_kind
            + ", bcd_id=" + bcd_id + ", bcd_content=" + bcd_content
            + ", bcd_path=" + bcd_path + ", bcd_info=" + bcd_info
            + ", bcd_kind=" + bcd_kind + "]";
   }
   public FileDown(String kategorie1, String kategorie2, String name,
         String uuidName, String webImgPath, String imgPath, String price,
         String content, String file_id, String ctgy_id1, String ctgy_id2,
         String ctgy_id3, String ctgy_kind) {
      super();
      this.kategorie1 = kategorie1;
      this.kategorie2 = kategorie2;
      this.name = name;
      this.uuidName = uuidName;
      this.webImgPath = webImgPath;
      this.imgPath = imgPath;
      this.price = price;
      this.content = content;
      this.file_id = file_id;
      this.ctgy_id1 = ctgy_id1;
      this.ctgy_id2 = ctgy_id2;
      this.ctgy_id3 = ctgy_id3;
      this.ctgy_kind = ctgy_kind;
   }
   public FileDown() {
      super();
      // TODO Auto-generated constructor stub
   }
   
   
   
   
}