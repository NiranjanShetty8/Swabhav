package repository

import (
	uuid "github.com/satori/go.uuid"
)

// Repository Struct
type Repository interface {
	GetAll(ufw *UnitOfWork, preloadAssociation []string) error
	Get(ufw *UnitOfWork, out interface{}, id uuid.UUID, preloadAssociation []string) error
	Add(ufw *UnitOfWork, input interface{}) error
	Delete(ufw *UnitOfWork, out interface{}) error
	Update(ufw *UnitOfWork, out interface{}) error
}

type StudentRepository struct {
}

func NewRepository() *StudentRepository {
	return &StudentRepository{}
}

func (repo *StudentRepository) Add(ufw *UnitOfWork, out interface{}) error {
	return ufw.DB.Create(out).Error
}

func (repo *StudentRepository) Get(ufw *UnitOfWork, id uuid.UUID, out interface{}) error {
	return ufw.DB.Debug().Model(out).First(out, "id = ?", id).Error
}

func (repo *StudentRepository) GetAll(ufw *UnitOfWork, out interface{}) error {
	return ufw.DB.Model(out).Find(out).Error
}

func (repo *StudentRepository) Update(ufw *UnitOfWork, entity interface{}) error {
	return ufw.DB.Model(entity).Update(entity).Error
}

func (repo *StudentRepository) Delete(ufw *UnitOfWork, id uuid.UUID, out interface{}) error {
	return ufw.DB.Model(out).Delete(out, "id = ?", id).Error
}
