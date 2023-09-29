
provider "aws" {
  region = "us-east-1"
}

resource "aws_sqs_queue" "example_queue" {
  name                      = "fila-atendimento-cielo"
  delay_seconds             = 0
  max_message_size          = 256000
  message_retention_seconds = 86400 # 1 dia
  receive_wait_time_seconds = 0
}
