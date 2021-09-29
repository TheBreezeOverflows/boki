package boke.boke.entity;

import java.util.ArrayList;
import java.util.List;

public class ProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectExample() {
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

        public Criteria andProjectIdIsNull() {
            addCriterion("Project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("Project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(Integer value) {
            addCriterion("Project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Integer value) {
            addCriterion("Project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Integer value) {
            addCriterion("Project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Integer value) {
            addCriterion("Project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("Project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Integer> values) {
            addCriterion("Project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Integer> values) {
            addCriterion("Project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Integer value1, Integer value2) {
            addCriterion("Project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("Project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("Project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("Project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("Project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("Project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("Project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("Project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("Project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("Project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("Project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("Project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("Project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("Project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("Project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceIsNull() {
            addCriterion("Project_introduce is null");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceIsNotNull() {
            addCriterion("Project_introduce is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceEqualTo(String value) {
            addCriterion("Project_introduce =", value, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceNotEqualTo(String value) {
            addCriterion("Project_introduce <>", value, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceGreaterThan(String value) {
            addCriterion("Project_introduce >", value, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("Project_introduce >=", value, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceLessThan(String value) {
            addCriterion("Project_introduce <", value, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceLessThanOrEqualTo(String value) {
            addCriterion("Project_introduce <=", value, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceLike(String value) {
            addCriterion("Project_introduce like", value, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceNotLike(String value) {
            addCriterion("Project_introduce not like", value, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceIn(List<String> values) {
            addCriterion("Project_introduce in", values, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceNotIn(List<String> values) {
            addCriterion("Project_introduce not in", values, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceBetween(String value1, String value2) {
            addCriterion("Project_introduce between", value1, value2, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectIntroduceNotBetween(String value1, String value2) {
            addCriterion("Project_introduce not between", value1, value2, "projectIntroduce");
            return (Criteria) this;
        }

        public Criteria andProjectShowIsNull() {
            addCriterion("Project_show is null");
            return (Criteria) this;
        }

        public Criteria andProjectShowIsNotNull() {
            addCriterion("Project_show is not null");
            return (Criteria) this;
        }

        public Criteria andProjectShowEqualTo(String value) {
            addCriterion("Project_show =", value, "projectShow");
            return (Criteria) this;
        }

        public Criteria andProjectShowNotEqualTo(String value) {
            addCriterion("Project_show <>", value, "projectShow");
            return (Criteria) this;
        }

        public Criteria andProjectShowGreaterThan(String value) {
            addCriterion("Project_show >", value, "projectShow");
            return (Criteria) this;
        }

        public Criteria andProjectShowGreaterThanOrEqualTo(String value) {
            addCriterion("Project_show >=", value, "projectShow");
            return (Criteria) this;
        }

        public Criteria andProjectShowLessThan(String value) {
            addCriterion("Project_show <", value, "projectShow");
            return (Criteria) this;
        }

        public Criteria andProjectShowLessThanOrEqualTo(String value) {
            addCriterion("Project_show <=", value, "projectShow");
            return (Criteria) this;
        }

        public Criteria andProjectShowLike(String value) {
            addCriterion("Project_show like", value, "projectShow");
            return (Criteria) this;
        }

        public Criteria andProjectShowNotLike(String value) {
            addCriterion("Project_show not like", value, "projectShow");
            return (Criteria) this;
        }

        public Criteria andProjectShowIn(List<String> values) {
            addCriterion("Project_show in", values, "projectShow");
            return (Criteria) this;
        }

        public Criteria andProjectShowNotIn(List<String> values) {
            addCriterion("Project_show not in", values, "projectShow");
            return (Criteria) this;
        }

        public Criteria andProjectShowBetween(String value1, String value2) {
            addCriterion("Project_show between", value1, value2, "projectShow");
            return (Criteria) this;
        }

        public Criteria andProjectShowNotBetween(String value1, String value2) {
            addCriterion("Project_show not between", value1, value2, "projectShow");
            return (Criteria) this;
        }

        public Criteria andProjectStaicIsNull() {
            addCriterion("Project_staic is null");
            return (Criteria) this;
        }

        public Criteria andProjectStaicIsNotNull() {
            addCriterion("Project_staic is not null");
            return (Criteria) this;
        }

        public Criteria andProjectStaicEqualTo(Integer value) {
            addCriterion("Project_staic =", value, "projectStaic");
            return (Criteria) this;
        }

        public Criteria andProjectStaicNotEqualTo(Integer value) {
            addCriterion("Project_staic <>", value, "projectStaic");
            return (Criteria) this;
        }

        public Criteria andProjectStaicGreaterThan(Integer value) {
            addCriterion("Project_staic >", value, "projectStaic");
            return (Criteria) this;
        }

        public Criteria andProjectStaicGreaterThanOrEqualTo(Integer value) {
            addCriterion("Project_staic >=", value, "projectStaic");
            return (Criteria) this;
        }

        public Criteria andProjectStaicLessThan(Integer value) {
            addCriterion("Project_staic <", value, "projectStaic");
            return (Criteria) this;
        }

        public Criteria andProjectStaicLessThanOrEqualTo(Integer value) {
            addCriterion("Project_staic <=", value, "projectStaic");
            return (Criteria) this;
        }

        public Criteria andProjectStaicIn(List<Integer> values) {
            addCriterion("Project_staic in", values, "projectStaic");
            return (Criteria) this;
        }

        public Criteria andProjectStaicNotIn(List<Integer> values) {
            addCriterion("Project_staic not in", values, "projectStaic");
            return (Criteria) this;
        }

        public Criteria andProjectStaicBetween(Integer value1, Integer value2) {
            addCriterion("Project_staic between", value1, value2, "projectStaic");
            return (Criteria) this;
        }

        public Criteria andProjectStaicNotBetween(Integer value1, Integer value2) {
            addCriterion("Project_staic not between", value1, value2, "projectStaic");
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