<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${daoPackage}.${className}Mapper" >

    <resultMap id="${className}ResultMap" type="${domainPackage}.${className}" >
        ${column}
    </resultMap>

    <sql id="Base_Column_List">
        ${baseColumnList}
    </sql>
    <sql id="Where">
        <where> 1=1
        </where>
    </sql>
    <sql id="OrderBy">
        order by ${orderbyCloumn} desc
    </sql>
    <insert id="insert" keyProperty="id" useGeneratedKeys="true" parameterType="${domainPackage}.${className}">
        ${insert}
    </insert>
    <update id="update" parameterType="${domainPackage}.${className}">
        ${update}
    </update>
    <select id="selectById" parameterType="int" resultMap="${className}ResultMap">
        ${selectById}
    </select>
    <select id="select" parameterType="map" resultMap="${className}ResultMap">
        ${select}
    </select>
    <select id="selectByPage" parameterType="map" resultMap="${className}ResultMap">
        ${selectByPage}
    </select>
    <select id="selectCount" parameterType="map" resultType="int">
        ${selectCount}
    </select>
    <delete id="deleteById" parameterType="int">
        ${deleteById}
    </delete>
    <delete id="delete" parameterType="int">
        ${delete}
    </delete>
</mapper>