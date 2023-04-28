import React, { useEffect, useState } from "react";
import { Alert, Button, Col, Container, Row } from "react-bootstrap";
import CardComponent from "./CardComponent";

const MainComponent = () => {
  const [data, setData] = useState([]);
  const [show, setShow] = useState(false);
  const [error, setError] = useState(false);

  const userFetch = async () => {
    const response = await fetch("http://localhost:8082/personae/data1");
    if (response.ok) {
      const data = await response;
      console.log(data);
    }
  };

  const userFetch2 = async () => {
    setError(false);
    try {
      const response = await fetch("http://localhost:8082/personae/data3", {
        headers: {
          Authorization:
            "Bearer eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJwaXBwby5nb29meS5waXBwb0BleC5jb20iLCJpYXQiOjE2ODI1MTg0ODgsImV4cCI6MTY4MzEyMzI4OH0.x1jr9O4ovat1FQlI5vtlOLsI2EfoTVz8LB5pafdp25o3Fl6Wu0-X-4e8oXPrA0O2",
        },
      });
      if (response.ok) {
        const data = await response.json();
        setData(data);
      } else {
        setError(true);
      }
    } catch (e) {
      setError(true);
    }
  };

  useEffect(() => {
    userFetch();
  }, []);

  useEffect(() => {
    if (show) {
      userFetch2();
    }
  }, [show]);
  return (
    <Container className="100vh">
      <h1 className="mt-3">Comunicazione client to server</h1>
      <Row className="justify-content-between">
        {(!error &&
          show &&
          data?.length > 0 &&
          data?.map((e, i) => (
            <CardComponent
              key={e.id + `${i}`}
              id={e?.id}
              nome={e?.nome}
              username={e?.username}
              email={e?.email}
            />
          ))) ||
          (error && (
            <Alert variant="danger" onClose={() => setShow(false)} dismissible>
              <Alert.Heading>Oh snap! You got an error!</Alert.Heading>
              <p>
                Change this and that and try again. Duis mollis, est non commodo
                luctus, nisi erat porttitor ligula, eget lacinia odio sem nec
                elit. Cras mattis consectetur purus sit amet fermentum.
              </p>
            </Alert>
          ))}
      </Row>
      <div
        style={{
          height: !show ? "100vh" : "16px",
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
        }}
      >
        <Button
          className={(!show ? "bg-primary" : "bg-success") + " py-3"}
          style={{ width: "10rem" }}
          onClick={() => {
            setShow(!show);
          }}
        >
          Mostra
        </Button>
      </div>
    </Container>
  );
};

export default MainComponent;
