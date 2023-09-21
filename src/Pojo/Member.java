package Pojo;

public class Member {
    private Integer id;
    private String name;
    private String stuId;
    private String post;
    private String college;
    private String email;
    private String phone;


    public Member() {
    }

    public Member(Integer id, String name, String stuId, String post, String college, String email, String phone) {
        this.id = id;
        this.name = name;
        this.stuId = stuId;
        this.post = post;
        this.college = college;
        this.email = email;
        this.phone = phone;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return stuId
     */
    public String getStuId() {
        return stuId;
    }

    /**
     * 设置
     * @param stuId
     */
    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    /**
     * 获取
     * @return post
     */
    public String getPost() {
        return post;
    }

    /**
     * 设置
     * @param post
     */
    public void setPost(String post) {
        this.post = post;
    }

    /**
     * 获取
     * @return college
     */
    public String getCollege() {
        return college;
    }

    /**
     * 设置
     * @param college
     */
    public void setCollege(String college) {
        this.college = college;
    }

    /**
     * 获取
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        return "member{id = " + id + ", name = " + name + ", stuId = " + stuId + ", post = " + post + ", college = " + college + ", email = " + email + ", phone = " + phone + "}";
    }
}
