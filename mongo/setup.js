db = db.getSiblingDB("files");

db.createUser({
    user: "ques",
    pwd: "quesadilla",
    roles: [{ role: "readWrite", db: "files" }]
});

db.createCollection("files");