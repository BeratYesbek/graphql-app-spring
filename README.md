Simple Graphql application that contains PostgreSQL and Hibernate
### Queries
```
query{
  getAuthorById(id:1) {
    id
    firstName
    lastName
    books {
      id
      name
      pageCount
    }
  }
}

```

```
query{
  bookById(id:1) {
    id
    name
    pageCount
    author {
      id
      firstName
      lastName
    }
  }
}

```

```
query{
  books {
    id
    name
    pageCount
    author {
      id
      firstName
      lastName
    }
  }
}
```

### Mutations

```
mutation{
  createBook(name: "Incognito: The Secret Lives of the Brain", pageCount: 304, authorId: 3) {
    id
    name
    pageCount
    author {
      id
      firstName
      lastName
    }
  }
}
```

```
mutation{
  updateBook(id:3,name: "Incognito: The Secret Lives of the Brain", pageCount: 304, authorId: 3) {
    id
    name
    pageCount
    author {
      id
      firstName
      lastName
    }
  }
}
```

```
mutation{
  deleteBook(id:3) 
}
```

```
mutation{
  createAuthor(firstName:"Fyodor Mikhailovich",lastName: "Dostoevsky") {
    id
    firstName
    lastName
  }
}
```

```
mutation{
  updateAuthor(id: 4,firstName:"Fyodor Mikhailovich",lastName: "Dostoevsky") {
    id
    firstName
    lastName
  }
}
```
