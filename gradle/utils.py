package utils

import json
from flask import Response

class UtilityFunctions:
    def __init__(self, config):
        self.config = config

    def validate_parameters(self, genre, page, limit):
        if not genre:
            raise ValueError("Genre is required")
        if not isinstance(page, int) or not isinstance(limit, int):
            raise ValueError("Page and limit must be integers")
        if page < 1 or limit < 1:
            raise ValueError("Page and limit must be positive integers")
        if limit > self.config.get('max_limit', 100):
            raise ValueError("Limit is too large")

    def create_response(self, data, next_page_url=None):
        try:
            response_data = {
                "data": data,
            }
            if next_page_url:
                response_data["next_page_url"] = next_page_url
            response = Response(json.dumps(response_data), status=200, mimetype="application/json")
            return response
        except Exception as e:
            response = Response(json.dumps({"error": str(e)}), status=500, mimetype="application/json")
            return response

    def get_config(self):
        return self.config

    def set_config(self, config):
        self.config = config

    def format_next_page_url(self, page, limit, genre):
        return f"/books?genre={genre}&page={page+1}&limit={limit}"