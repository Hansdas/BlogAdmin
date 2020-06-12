package ${daoPackage};

import ${domainPackage}.${domainName};
import java.util.List;

public interface ${className}Mapper {

    int insert(${domainName} ${domainNamePara});

    int update(${domainName} ${domainNamePara});

    ${domainName} selectById(int id);

    List<${domainName}> selectByPage(int currentPage,int pageSize);

    void Delete(int id);
}