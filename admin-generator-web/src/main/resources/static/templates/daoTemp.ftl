package ${daoPackage};

import ${domainPackage}.${domainName};
import java.util.List;

public interface ${className}Dao {

    int insert(${domainName} ${domainNamePara});

    int update(${domainName} ${domainNamePara});

    ${domainName} selectById(int id);

    List<${domainName}> selectByPage(int currentPage,int pageSize);

    void Delete(int id);
}