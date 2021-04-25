protoc -I src/ --go_out=./src ./src/simple/simple.proto 

protoc -I src/ --go_out=./src/enumjose ./src/simple/enum_example.proto 

protoc -I src/ --go_out=./src/complexpb ./src/simple/complex.proto 