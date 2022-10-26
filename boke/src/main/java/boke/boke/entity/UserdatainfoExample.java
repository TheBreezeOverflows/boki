package boke.boke.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserdatainfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserdatainfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUserinfoIdIsNull() {
            addCriterion("UserInfo_id is null");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdIsNotNull() {
            addCriterion("UserInfo_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdEqualTo(Integer value) {
            addCriterion("UserInfo_id =", value, "userinfoId");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdNotEqualTo(Integer value) {
            addCriterion("UserInfo_id <>", value, "userinfoId");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdGreaterThan(Integer value) {
            addCriterion("UserInfo_id >", value, "userinfoId");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("UserInfo_id >=", value, "userinfoId");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdLessThan(Integer value) {
            addCriterion("UserInfo_id <", value, "userinfoId");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdLessThanOrEqualTo(Integer value) {
            addCriterion("UserInfo_id <=", value, "userinfoId");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdIn(List<Integer> values) {
            addCriterion("UserInfo_id in", values, "userinfoId");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdNotIn(List<Integer> values) {
            addCriterion("UserInfo_id not in", values, "userinfoId");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdBetween(Integer value1, Integer value2) {
            addCriterion("UserInfo_id between", value1, value2, "userinfoId");
            return (Criteria) this;
        }

        public Criteria andUserinfoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("UserInfo_id not between", value1, value2, "userinfoId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("User_Id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("User_Id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("User_Id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("User_Id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("User_Id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("User_Id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("User_Id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("User_Id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("User_Id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("User_Id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("User_Id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("User_Id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserTimeIsNull() {
            addCriterion("User_time is null");
            return (Criteria) this;
        }

        public Criteria andUserTimeIsNotNull() {
            addCriterion("User_time is not null");
            return (Criteria) this;
        }

        public Criteria andUserTimeEqualTo(Date value) {
            addCriterion("User_time =", value, "userTime");
            return (Criteria) this;
        }

        public Criteria andUserTimeNotEqualTo(Date value) {
            addCriterion("User_time <>", value, "userTime");
            return (Criteria) this;
        }

        public Criteria andUserTimeGreaterThan(Date value) {
            addCriterion("User_time >", value, "userTime");
            return (Criteria) this;
        }

        public Criteria andUserTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("User_time >=", value, "userTime");
            return (Criteria) this;
        }

        public Criteria andUserTimeLessThan(Date value) {
            addCriterion("User_time <", value, "userTime");
            return (Criteria) this;
        }

        public Criteria andUserTimeLessThanOrEqualTo(Date value) {
            addCriterion("User_time <=", value, "userTime");
            return (Criteria) this;
        }

        public Criteria andUserTimeIn(List<Date> values) {
            addCriterion("User_time in", values, "userTime");
            return (Criteria) this;
        }

        public Criteria andUserTimeNotIn(List<Date> values) {
            addCriterion("User_time not in", values, "userTime");
            return (Criteria) this;
        }

        public Criteria andUserTimeBetween(Date value1, Date value2) {
            addCriterion("User_time between", value1, value2, "userTime");
            return (Criteria) this;
        }

        public Criteria andUserTimeNotBetween(Date value1, Date value2) {
            addCriterion("User_time not between", value1, value2, "userTime");
            return (Criteria) this;
        }

        public Criteria andUserBirthdaydateIsNull() {
            addCriterion("User_BirthdayDate is null");
            return (Criteria) this;
        }

        public Criteria andUserBirthdaydateIsNotNull() {
            addCriterion("User_BirthdayDate is not null");
            return (Criteria) this;
        }

        public Criteria andUserBirthdaydateEqualTo(Date value) {
            addCriterion("User_BirthdayDate =", value, "userBirthdaydate");
            return (Criteria) this;
        }

        public Criteria andUserBirthdaydateNotEqualTo(Date value) {
            addCriterion("User_BirthdayDate <>", value, "userBirthdaydate");
            return (Criteria) this;
        }

        public Criteria andUserBirthdaydateGreaterThan(Date value) {
            addCriterion("User_BirthdayDate >", value, "userBirthdaydate");
            return (Criteria) this;
        }

        public Criteria andUserBirthdaydateGreaterThanOrEqualTo(Date value) {
            addCriterion("User_BirthdayDate >=", value, "userBirthdaydate");
            return (Criteria) this;
        }

        public Criteria andUserBirthdaydateLessThan(Date value) {
            addCriterion("User_BirthdayDate <", value, "userBirthdaydate");
            return (Criteria) this;
        }

        public Criteria andUserBirthdaydateLessThanOrEqualTo(Date value) {
            addCriterion("User_BirthdayDate <=", value, "userBirthdaydate");
            return (Criteria) this;
        }

        public Criteria andUserBirthdaydateIn(List<Date> values) {
            addCriterion("User_BirthdayDate in", values, "userBirthdaydate");
            return (Criteria) this;
        }

        public Criteria andUserBirthdaydateNotIn(List<Date> values) {
            addCriterion("User_BirthdayDate not in", values, "userBirthdaydate");
            return (Criteria) this;
        }

        public Criteria andUserBirthdaydateBetween(Date value1, Date value2) {
            addCriterion("User_BirthdayDate between", value1, value2, "userBirthdaydate");
            return (Criteria) this;
        }

        public Criteria andUserBirthdaydateNotBetween(Date value1, Date value2) {
            addCriterion("User_BirthdayDate not between", value1, value2, "userBirthdaydate");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNull() {
            addCriterion("User_email is null");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNotNull() {
            addCriterion("User_email is not null");
            return (Criteria) this;
        }

        public Criteria andUserEmailEqualTo(String value) {
            addCriterion("User_email =", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotEqualTo(String value) {
            addCriterion("User_email <>", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThan(String value) {
            addCriterion("User_email >", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThanOrEqualTo(String value) {
            addCriterion("User_email >=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThan(String value) {
            addCriterion("User_email <", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThanOrEqualTo(String value) {
            addCriterion("User_email <=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLike(String value) {
            addCriterion("User_email like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotLike(String value) {
            addCriterion("User_email not like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailIn(List<String> values) {
            addCriterion("User_email in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotIn(List<String> values) {
            addCriterion("User_email not in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailBetween(String value1, String value2) {
            addCriterion("User_email between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotBetween(String value1, String value2) {
            addCriterion("User_email not between", value1, value2, "userEmail");
            return (Criteria) this;
        }


        public Criteria andUserIntroIsNull() {
            addCriterion("User_Intro is null");
            return (Criteria) this;
        }

        public Criteria andUserIntroIsNotNull() {
            addCriterion("User_Intro is not null");
            return (Criteria) this;
        }

        public Criteria andUserIntroEqualTo(String value) {
            addCriterion("User_Intro =", value, "userIntro");
            return (Criteria) this;
        }

        public Criteria andUserIntroNotEqualTo(String value) {
            addCriterion("User_Intro <>", value, "userIntro");
            return (Criteria) this;
        }

        public Criteria andUserIntroGreaterThan(String value) {
            addCriterion("User_Intro >", value, "userIntro");
            return (Criteria) this;
        }

        public Criteria andUserIntroGreaterThanOrEqualTo(String value) {
            addCriterion("User_Intro >=", value, "userIntro");
            return (Criteria) this;
        }

        public Criteria andUserIntroLessThan(String value) {
            addCriterion("User_Intro <", value, "userIntro");
            return (Criteria) this;
        }

        public Criteria andUserIntroLessThanOrEqualTo(String value) {
            addCriterion("User_Intro <=", value, "userIntro");
            return (Criteria) this;
        }

        public Criteria andUserIntroLike(String value) {
            addCriterion("User_Intro like", value, "userIntro");
            return (Criteria) this;
        }

        public Criteria andUserIntroNotLike(String value) {
            addCriterion("User_Intro not like", value, "userIntro");
            return (Criteria) this;
        }

        public Criteria andUserIntroIn(List<String> values) {
            addCriterion("User_Intro in", values, "userIntro");
            return (Criteria) this;
        }

        public Criteria andUserIntroNotIn(List<String> values) {
            addCriterion("User_Intro not in", values, "userIntro");
            return (Criteria) this;
        }

        public Criteria andUserIntroBetween(String value1, String value2) {
            addCriterion("User_Intro between", value1, value2, "userIntro");
            return (Criteria) this;
        }

        public Criteria andUserIntroNotBetween(String value1, String value2) {
            addCriterion("User_Intro not between", value1, value2, "userIntro");
            return (Criteria) this;
        }

        public Criteria andUserImageIsNull() {
            addCriterion("User_Image is null");
            return (Criteria) this;
        }

        public Criteria andUserImageIsNotNull() {
            addCriterion("User_Image is not null");
            return (Criteria) this;
        }

        public Criteria andUserImageEqualTo(String value) {
            addCriterion("User_Image =", value, "userImage");
            return (Criteria) this;
        }

        public Criteria andUserImageNotEqualTo(String value) {
            addCriterion("User_Image <>", value, "userImage");
            return (Criteria) this;
        }

        public Criteria andUserImageGreaterThan(String value) {
            addCriterion("User_Image >", value, "userImage");
            return (Criteria) this;
        }

        public Criteria andUserImageGreaterThanOrEqualTo(String value) {
            addCriterion("User_Image >=", value, "userImage");
            return (Criteria) this;
        }

        public Criteria andUserImageLessThan(String value) {
            addCriterion("User_Image <", value, "userImage");
            return (Criteria) this;
        }

        public Criteria andUserImageLessThanOrEqualTo(String value) {
            addCriterion("User_Image <=", value, "userImage");
            return (Criteria) this;
        }

        public Criteria andUserImageLike(String value) {
            addCriterion("User_Image like", value, "userImage");
            return (Criteria) this;
        }

        public Criteria andUserImageNotLike(String value) {
            addCriterion("User_Image not like", value, "userImage");
            return (Criteria) this;
        }

        public Criteria andUserImageIn(List<String> values) {
            addCriterion("User_Image in", values, "userImage");
            return (Criteria) this;
        }

        public Criteria andUserImageNotIn(List<String> values) {
            addCriterion("User_Image not in", values, "userImage");
            return (Criteria) this;
        }

        public Criteria andUserImageBetween(String value1, String value2) {
            addCriterion("User_Image between", value1, value2, "userImage");
            return (Criteria) this;
        }

        public Criteria andUserImageNotBetween(String value1, String value2) {
            addCriterion("User_Image not between", value1, value2, "userImage");
            return (Criteria) this;
        }

        public Criteria andUserBokiIsNull() {
            addCriterion("User_boki is null");
            return (Criteria) this;
        }

        public Criteria andUserBokiIsNotNull() {
            addCriterion("User_boki is not null");
            return (Criteria) this;
        }

        public Criteria andUserBokiEqualTo(String value) {
            addCriterion("User_boki =", value, "userBoki");
            return (Criteria) this;
        }

        public Criteria andUserBokiNotEqualTo(String value) {
            addCriterion("User_boki <>", value, "userBoki");
            return (Criteria) this;
        }

        public Criteria andUserBokiGreaterThan(String value) {
            addCriterion("User_boki >", value, "userBoki");
            return (Criteria) this;
        }

        public Criteria andUserBokiGreaterThanOrEqualTo(String value) {
            addCriterion("User_boki >=", value, "userBoki");
            return (Criteria) this;
        }

        public Criteria andUserBokiLessThan(String value) {
            addCriterion("User_boki <", value, "userBoki");
            return (Criteria) this;
        }

        public Criteria andUserBokiLessThanOrEqualTo(String value) {
            addCriterion("User_boki <=", value, "userBoki");
            return (Criteria) this;
        }

        public Criteria andUserBokiLike(String value) {
            addCriterion("User_boki like", value, "userBoki");
            return (Criteria) this;
        }

        public Criteria andUserBokiNotLike(String value) {
            addCriterion("User_boki not like", value, "userBoki");
            return (Criteria) this;
        }

        public Criteria andUserBokiIn(List<String> values) {
            addCriterion("User_boki in", values, "userBoki");
            return (Criteria) this;
        }

        public Criteria andUserBokiNotIn(List<String> values) {
            addCriterion("User_boki not in", values, "userBoki");
            return (Criteria) this;
        }

        public Criteria andUserBokiBetween(String value1, String value2) {
            addCriterion("User_boki between", value1, value2, "userBoki");
            return (Criteria) this;
        }

        public Criteria andUserBokiNotBetween(String value1, String value2) {
            addCriterion("User_boki not between", value1, value2, "userBoki");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}