package gradle

class Genre:
    def __init__(self, id, name):
        if not isinstance(id, int):
            raise TypeError("Id must be an integer")
        if not isinstance(name, str):
            raise TypeError("Name must be a string")
        self.__id = id
        self.__name = name

    def get_id(self):
        return self.__id

    def set_id(self, id):
        if not isinstance(id, int):
            raise TypeError("Id must be an integer")
        self.__id = id

    def get_name(self):
        return self.__name

    def set_name(self, name):
        if not isinstance(name, str):
            raise TypeError("Name must be a string")
        self.__name = name