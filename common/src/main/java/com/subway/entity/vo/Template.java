package com.subway.entity.vo;


public class Template {
    private String touser;
    private String template_id;
    private String page;
    private String miniprogram_state;
    private String lang;
    private String data;

    public Template() {
    }

    public Template(String touser, String template_id, String page, String miniprogram_state, String lang) {
        this.touser = touser;
        this.template_id = template_id;
        this.page = page;
        this.miniprogram_state = miniprogram_state;
        this.lang = lang;
    }

    private static Template createTemplate(String touser, String template_id, String page, String miniprogram_state, String lang,
                                    String key1, String value1, String key2, String value2, String key3, String value3,
                                    String key4, String value4, String key5, String value5) {

        Template template = new Template(touser, template_id, page, miniprogram_state, lang);
        StringBuilder stringBuilder = new StringBuilder("{");
        stringBuilder.append('"').append(key1).append("\": {").append("\"value\": ").append("\"").append(value1).append("\"},")
                .append("\"").append(key2).append("\": {").append("\"value\": ").append("\"").append(value2).append("\"},")
                .append("\"").append(key3).append("\": {").append("\"value\": ").append("\"").append(value3).append("\"},")
                .append("\"").append(key4).append("\": {").append("\"value\": ").append("\"").append(value4).append("\"},")
                .append("\"").append(key5).append("\": {").append("\"value\": ").append("\"").append(value5).append("\"}")
                .append("}");
        template.data = stringBuilder.toString();
        System.out.println(stringBuilder.toString());
        return template;
    }

    public static Template getFaultTemplate(String touser, String template_id, String page, String miniprogram_state, String lang,
                                            String value1, String value2, String value3, String value4, String value5){
        Template template = createTemplate(touser, template_id, page, miniprogram_state, lang, "number1", value1, "thing21", value2, "name3", value3, "thing5", value4, "date6", value5);
        return template;
    }

    public static Template getAgreeTemplate(String touser, String template_id, String page, String miniprogram_state, String lang,
                                            String value1, String value2, String value3, String value4, String value5){
        Template template = createTemplate(touser, template_id, page, miniprogram_state, lang, "number1", value1, "thing13", value2, "thing2", value3, "name5", value4, "time15", value5);
        return template;
    }

    public static Template getRefuseTemplate(String touser, String template_id, String page, String miniprogram_state, String lang,
                                             String value1, String value2, String value3, String value4, String value5){
        Template template = createTemplate(touser, template_id, page, miniprogram_state, lang, "number1", value1, "thing2", value2, "name3", value3, "name4", value4, "thing5", value5);
        return template;
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getMiniprogram_state() {
        return miniprogram_state;
    }

    public void setMiniprogram_state(String miniprogram_state) {
        this.miniprogram_state = miniprogram_state;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "\"touser\": " +"\""+ touser  + "\""+
                ", \"template_id\": " + "\""+template_id + "\"" +
                ", \"page\": " + "\""+page+ "\"" +
                ", \"miniprogram_state\": " + "\""+miniprogram_state+ "\"" +
                ", \"lang\": " + "\""+lang+ "\"" +
                ", \"data\": " + data +
                '}';
    }

//    public static void main(String[] args) {
//        System.out.println(Template.getFaultTemplate("1", "1", "1", "1", "1", "1", "1", "1", "1", "1"));
//    }
}

