- show dbs
- show collections
- use gnemes   create database and switch to it.

### memo

  db.createUser(
   {
       user: "gnemes",
       pwd: "123456",
       roles: [
             { role: "userAdminAnyDatabase", db: "admin" },
          ]
   })

  mongodb://gnemes:123456@localhost/

  db.createUser(
    {
      user: 'gnemes',
      pwd: '123456',
      roles: [ { role: 'root', db: 'admin' } ]
    }
  );
  db.grantRolesToUser('gnemes', [{ role: 'root', db: 'admin' }])
