import { Card } from "react-bootstrap";

const CardComponent = ({ id, nome, username, email }) => {
  return (
    <Card className="my-5" style={{ width: "18rem" }}>
      <Card.Body>
        <Card.Title>{id}</Card.Title>
        <Card.Text>{nome}</Card.Text>
        <Card.Text>{username}</Card.Text>
        <Card.Link href="#">{email}</Card.Link>
      </Card.Body>
    </Card>
  );
};

export default CardComponent;
