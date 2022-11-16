#!/usr/bin/bash
IMAGE_NAME=czechprz/weight-monitoring-backend
sudo docker image build --tag $IMAGE_NAME .
