IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = N'bdrenade')
BEGIN
    CREATE DATABASE [bdrenade];
END
