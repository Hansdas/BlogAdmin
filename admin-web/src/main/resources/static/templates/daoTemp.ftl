package ${daoPackage};

import ${domainPackage}.${domainName};
import java.util.List;
import java.util.Map;
public interface ${className}Mapper {

    int insert(${domainName} ${domainNamePara});

    int update(${domainName} ${domainNamePara});

    ${domainName} selectById(int id);

    List<${domainName}> select(Map<String,Object> condition);

    List<${domainName}> selectByPage(Map<String,Object> condition);

    int selectCount(Map<String,Object> condition);

    void DeleteById(int id);

    void DeleteById(Map<String,Object> condition);
}