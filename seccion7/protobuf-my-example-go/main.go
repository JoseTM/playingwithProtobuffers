package main

import (
	"fmt"
	"io/ioutil"
	"log"
	"os"

	"google.golang.org/protobuf/encoding/protojson"
	"google.golang.org/protobuf/proto"
	"pecera.org/enumjosepb"
	"pecera.org/simplejosepb"
)

func main() {
	fmt.Println("hello world")
	sm := doSimple()
	writeToFile("mensajepb.bin", sm)

	pb := &simplejosepb.SimpleMessage{}
	err := readfromFile("mensajepb.bin", pb)
	if err != nil {
		log.Fatalln("cagada  ", err)
		os.Exit(1)
	}

	fmt.Println(pb)

	jsonstr := toJson(sm)
	fmt.Println(jsonstr)
	fmt.Println(fromJson(jsonstr))

	getEnum()
}

func writeToFile(fname string, pb proto.Message) error {

	out, err := proto.Marshal(pb)
	if err != nil {
		log.Fatalln("cagada  ", err)
		return err
	}

	errW := ioutil.WriteFile(fname, out, 0644)
	if errW != nil {
		log.Fatalln("cagada  ", errW)
		return errW
	}
	return nil
}

func readfromFile(fname string, pb proto.Message) error {

	messageBytes, err := ioutil.ReadFile(fname)
	if err != nil {
		log.Fatalln("cagada  ", err)
		return err
	}

	errR := proto.Unmarshal(messageBytes, pb)
	if errR != nil {
		log.Fatalln("cagada  ", errR)
		return errR
	}

	return nil
}

func doSimple() *simplejosepb.SimpleMessage {

	sm := simplejosepb.SimpleMessage{
		Id:         123456,
		IsSimple:   true,
		Name:       "nombre",
		SampleList: []int32{6, 7, 8, 9},
	}

	fmt.Println(sm.String())
	sm.Name = "cambate"

	fmt.Println(sm.String())
	fmt.Println(sm.GetId())
	sm.ProtoMessage()

	return &sm
}

func toJson(ms *simplejosepb.SimpleMessage) string {
	marshaller := protojson.MarshalOptions{}
	msgstr := marshaller.Format(ms)

	return msgstr
}

func fromJson(jsonStr string) *simplejosepb.SimpleMessage {
	msg := &simplejosepb.SimpleMessage{}
	unMarshaller := protojson.UnmarshalOptions{}
	err := unMarshaller.Unmarshal([]byte(jsonStr), msg)

	if err != nil {
		log.Fatalln("cagada  ", err)
		os.Exit(1)
	}

	return msg
}

func getEnum() {
	enum := enumjosepb.DayOfTheWeek_FRIDAY

	fmt.Println(enum)
}

/* func complexMatters() {
	complex := complexjosepb.ComplexMessage{}
	dummy := complexjosepb.DummyMessage{}

} */
