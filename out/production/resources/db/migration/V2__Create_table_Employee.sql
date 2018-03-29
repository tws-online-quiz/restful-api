CREATE TABLE Employee(
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(10),
    companyId INT NOT NULL,
    salary INT NOT NULL,
    constraint `company_id_for` FOREIGN KEY (`companyId`) REFERENCES `Company` (`id`) on delete cascade on update cascade
) engine=InnoDB DEFAULT CHARSET = utf8;

