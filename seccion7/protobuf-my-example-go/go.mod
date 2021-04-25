module pecera.org/probuf

go 1.16

require (
	google.golang.org/protobuf v1.26.0
	pecera.org/complexjosepb v0.0.0-00010101000000-000000000000 // indirect
	pecera.org/enumjosepb v0.0.0-00010101000000-000000000000
	pecera.org/simplejosepb v0.0.0-00010101000000-000000000000
)

replace pecera.org/simplejosepb => ./src

replace pecera.org/enumjosepb => ./src/enumjose

replace pecera.org/complexjosepb => ./src/complexpb
