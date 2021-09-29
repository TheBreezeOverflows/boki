package boke.boke.entity;

import java.util.ArrayList;
import java.util.List;

public class AdtvsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdtvsExample() {
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

        public Criteria andAdvtsIdIsNull() {
            addCriterion("Advts_id is null");
            return (Criteria) this;
        }

        public Criteria andAdvtsIdIsNotNull() {
            addCriterion("Advts_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdvtsIdEqualTo(Integer value) {
            addCriterion("Advts_id =", value, "advtsId");
            return (Criteria) this;
        }

        public Criteria andAdvtsIdNotEqualTo(Integer value) {
            addCriterion("Advts_id <>", value, "advtsId");
            return (Criteria) this;
        }

        public Criteria andAdvtsIdGreaterThan(Integer value) {
            addCriterion("Advts_id >", value, "advtsId");
            return (Criteria) this;
        }

        public Criteria andAdvtsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Advts_id >=", value, "advtsId");
            return (Criteria) this;
        }

        public Criteria andAdvtsIdLessThan(Integer value) {
            addCriterion("Advts_id <", value, "advtsId");
            return (Criteria) this;
        }

        public Criteria andAdvtsIdLessThanOrEqualTo(Integer value) {
            addCriterion("Advts_id <=", value, "advtsId");
            return (Criteria) this;
        }

        public Criteria andAdvtsIdIn(List<Integer> values) {
            addCriterion("Advts_id in", values, "advtsId");
            return (Criteria) this;
        }

        public Criteria andAdvtsIdNotIn(List<Integer> values) {
            addCriterion("Advts_id not in", values, "advtsId");
            return (Criteria) this;
        }

        public Criteria andAdvtsIdBetween(Integer value1, Integer value2) {
            addCriterion("Advts_id between", value1, value2, "advtsId");
            return (Criteria) this;
        }

        public Criteria andAdvtsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Advts_id not between", value1, value2, "advtsId");
            return (Criteria) this;
        }

        public Criteria andAdvtsImagepathIsNull() {
            addCriterion("Advts_imagePath is null");
            return (Criteria) this;
        }

        public Criteria andAdvtsImagepathIsNotNull() {
            addCriterion("Advts_imagePath is not null");
            return (Criteria) this;
        }

        public Criteria andAdvtsImagepathEqualTo(String value) {
            addCriterion("Advts_imagePath =", value, "advtsImagepath");
            return (Criteria) this;
        }

        public Criteria andAdvtsImagepathNotEqualTo(String value) {
            addCriterion("Advts_imagePath <>", value, "advtsImagepath");
            return (Criteria) this;
        }

        public Criteria andAdvtsImagepathGreaterThan(String value) {
            addCriterion("Advts_imagePath >", value, "advtsImagepath");
            return (Criteria) this;
        }

        public Criteria andAdvtsImagepathGreaterThanOrEqualTo(String value) {
            addCriterion("Advts_imagePath >=", value, "advtsImagepath");
            return (Criteria) this;
        }

        public Criteria andAdvtsImagepathLessThan(String value) {
            addCriterion("Advts_imagePath <", value, "advtsImagepath");
            return (Criteria) this;
        }

        public Criteria andAdvtsImagepathLessThanOrEqualTo(String value) {
            addCriterion("Advts_imagePath <=", value, "advtsImagepath");
            return (Criteria) this;
        }

        public Criteria andAdvtsImagepathLike(String value) {
            addCriterion("Advts_imagePath like", value, "advtsImagepath");
            return (Criteria) this;
        }

        public Criteria andAdvtsImagepathNotLike(String value) {
            addCriterion("Advts_imagePath not like", value, "advtsImagepath");
            return (Criteria) this;
        }

        public Criteria andAdvtsImagepathIn(List<String> values) {
            addCriterion("Advts_imagePath in", values, "advtsImagepath");
            return (Criteria) this;
        }

        public Criteria andAdvtsImagepathNotIn(List<String> values) {
            addCriterion("Advts_imagePath not in", values, "advtsImagepath");
            return (Criteria) this;
        }

        public Criteria andAdvtsImagepathBetween(String value1, String value2) {
            addCriterion("Advts_imagePath between", value1, value2, "advtsImagepath");
            return (Criteria) this;
        }

        public Criteria andAdvtsImagepathNotBetween(String value1, String value2) {
            addCriterion("Advts_imagePath not between", value1, value2, "advtsImagepath");
            return (Criteria) this;
        }

        public Criteria andAdtvsPathIsNull() {
            addCriterion("Adtvs_Path is null");
            return (Criteria) this;
        }

        public Criteria andAdtvsPathIsNotNull() {
            addCriterion("Adtvs_Path is not null");
            return (Criteria) this;
        }

        public Criteria andAdtvsPathEqualTo(String value) {
            addCriterion("Adtvs_Path =", value, "adtvsPath");
            return (Criteria) this;
        }

        public Criteria andAdtvsPathNotEqualTo(String value) {
            addCriterion("Adtvs_Path <>", value, "adtvsPath");
            return (Criteria) this;
        }

        public Criteria andAdtvsPathGreaterThan(String value) {
            addCriterion("Adtvs_Path >", value, "adtvsPath");
            return (Criteria) this;
        }

        public Criteria andAdtvsPathGreaterThanOrEqualTo(String value) {
            addCriterion("Adtvs_Path >=", value, "adtvsPath");
            return (Criteria) this;
        }

        public Criteria andAdtvsPathLessThan(String value) {
            addCriterion("Adtvs_Path <", value, "adtvsPath");
            return (Criteria) this;
        }

        public Criteria andAdtvsPathLessThanOrEqualTo(String value) {
            addCriterion("Adtvs_Path <=", value, "adtvsPath");
            return (Criteria) this;
        }

        public Criteria andAdtvsPathLike(String value) {
            addCriterion("Adtvs_Path like", value, "adtvsPath");
            return (Criteria) this;
        }

        public Criteria andAdtvsPathNotLike(String value) {
            addCriterion("Adtvs_Path not like", value, "adtvsPath");
            return (Criteria) this;
        }

        public Criteria andAdtvsPathIn(List<String> values) {
            addCriterion("Adtvs_Path in", values, "adtvsPath");
            return (Criteria) this;
        }

        public Criteria andAdtvsPathNotIn(List<String> values) {
            addCriterion("Adtvs_Path not in", values, "adtvsPath");
            return (Criteria) this;
        }

        public Criteria andAdtvsPathBetween(String value1, String value2) {
            addCriterion("Adtvs_Path between", value1, value2, "adtvsPath");
            return (Criteria) this;
        }

        public Criteria andAdtvsPathNotBetween(String value1, String value2) {
            addCriterion("Adtvs_Path not between", value1, value2, "adtvsPath");
            return (Criteria) this;
        }

        public Criteria andAdtvsIntroducedIsNull() {
            addCriterion("Adtvs_Introduced is null");
            return (Criteria) this;
        }

        public Criteria andAdtvsIntroducedIsNotNull() {
            addCriterion("Adtvs_Introduced is not null");
            return (Criteria) this;
        }

        public Criteria andAdtvsIntroducedEqualTo(String value) {
            addCriterion("Adtvs_Introduced =", value, "adtvsIntroduced");
            return (Criteria) this;
        }

        public Criteria andAdtvsIntroducedNotEqualTo(String value) {
            addCriterion("Adtvs_Introduced <>", value, "adtvsIntroduced");
            return (Criteria) this;
        }

        public Criteria andAdtvsIntroducedGreaterThan(String value) {
            addCriterion("Adtvs_Introduced >", value, "adtvsIntroduced");
            return (Criteria) this;
        }

        public Criteria andAdtvsIntroducedGreaterThanOrEqualTo(String value) {
            addCriterion("Adtvs_Introduced >=", value, "adtvsIntroduced");
            return (Criteria) this;
        }

        public Criteria andAdtvsIntroducedLessThan(String value) {
            addCriterion("Adtvs_Introduced <", value, "adtvsIntroduced");
            return (Criteria) this;
        }

        public Criteria andAdtvsIntroducedLessThanOrEqualTo(String value) {
            addCriterion("Adtvs_Introduced <=", value, "adtvsIntroduced");
            return (Criteria) this;
        }

        public Criteria andAdtvsIntroducedLike(String value) {
            addCriterion("Adtvs_Introduced like", value, "adtvsIntroduced");
            return (Criteria) this;
        }

        public Criteria andAdtvsIntroducedNotLike(String value) {
            addCriterion("Adtvs_Introduced not like", value, "adtvsIntroduced");
            return (Criteria) this;
        }

        public Criteria andAdtvsIntroducedIn(List<String> values) {
            addCriterion("Adtvs_Introduced in", values, "adtvsIntroduced");
            return (Criteria) this;
        }

        public Criteria andAdtvsIntroducedNotIn(List<String> values) {
            addCriterion("Adtvs_Introduced not in", values, "adtvsIntroduced");
            return (Criteria) this;
        }

        public Criteria andAdtvsIntroducedBetween(String value1, String value2) {
            addCriterion("Adtvs_Introduced between", value1, value2, "adtvsIntroduced");
            return (Criteria) this;
        }

        public Criteria andAdtvsIntroducedNotBetween(String value1, String value2) {
            addCriterion("Adtvs_Introduced not between", value1, value2, "adtvsIntroduced");
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