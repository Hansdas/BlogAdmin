<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${daoPackage}.${className}Dao" >

    <resultMap id="${className}ResultMap" type="${domainPackage}${className}" >
        ${column}
    </resultMap>

    <sql id="Base_Column_List">
        ${baseColumnList}
    </sql>
    <sql id="Where">
        <where> 1=1
        </where>
    </sql>
    <insert id="insert" keyProperty="id" useGeneratedKeys="true" parameterType="${domainPackage}${className}">
       ${insert}
    </insert>
    <update id="update" parameterType="com.myschool.student.entity.StudentInfo">
        ${update}
    </update>
    <update id="selectById" parameterType="com.myschool.student.entity.StudentInfo">
        ${selectById}
    </update>
    <update id="selectByPage" parameterType="com.myschool.student.entity.StudentInfo">
        ${selectById}
    </update>
    <update id="deleteById" parameterType="com.myschool.student.entity.StudentInfo">
        ${deleteById}
    </update>
</mapper>
